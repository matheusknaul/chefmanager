from flask import url_for, jsonify, Blueprint, request
from app.connection import conn
from werkzeug.security import check_password_hash

recipes_bp = Blueprint('recipes', __name__)

cursor = conn.cursor(dictionary=True)

@recipes_bp.route('/', methods=['GET'])
def get_all():
    cursor.execute("SELECT * FROM recipe")
    recipes = cursor.fetchall()

    return jsonify(recipes), 200

@recipes_bp.route('/<int:id>', methods=['GET'])
def get_by_id(id):
    cursor.execute("SELECT * FROM recipe WHERE id = %s", (id,))
    recipe = cursor.fetchone()

    if recipe:
        return jsonify(recipe), 200
    else:
        jsonify({"message": "Recipe not found."}), 404

@recipes_bp.route('/create', methods=['POST'])
def create():
    data = request.json

    title = data.get('title')
    description = data.get('description')
    user_id = data.get('user_id')

    try:
        cursor.execute(
            "INSERT INTO recipe (title, user_id , description) VALUES (%s, %s, %s)",
            (title, user_id , description)
        )
        conn.commit()

        recipe_id = cursor.lastrowid  

        return jsonify({
            "message": "Receita cadastrada com sucesso!",
            "recipe": {
                "id": recipe_id,
                "user_id": user_id,
                "title": title,
                "description": description
            }
        }), 201

    except Exception as e:
        print(f"Erro ao inserir a receita: {e}")
        return jsonify({"error": "Erro ao criar a receita. Tente novamente!"}), 500


@recipes_bp.route('/update/<int:id>', methods=['PUT'])
def update(id):
    data = request.json
    if data:
        title = data.get('tile')
        description = data.get('description')

        cursor.execute("UPDATE recipe SET title = %s, description = %s WHERE id = %s"
                       ,(title, description, id))
        conn.commit()
        return jsonify({"message": "Updated"}, 200)
    else:
        return jsonify({"message": "Recipe not found!"}, 404)

@recipes_bp.route('/delete/<int:id>', methods=['DELETE'])
def delete(id):
    try:
        cursor.execute(
            "DELETE FROM recipe WHERE id = %s",
            (id,)
        )
        conn.commit()
        return jsonify({"message": "Deleted"}), 204 
    except Exception as e:
        return jsonify({"error": "Erro ao deletar a receita!"}), 500