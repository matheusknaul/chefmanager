from flask import url_for, jsonify, Blueprint, request
from app.connection import conn
from werkzeug.security import check_password_hash

ingredients_bp = Blueprint('ingredients', __name__)

cursor = conn.cursor(dictionary=True)

@ingredients_bp.route('/', methods=['GET'])
def get_all():
    cursor.execute("SELECT * FROM ingredient")
    ingredients = cursor.fetchall()

    return jsonify(ingredients), 200

@ingredients_bp.route('/<int:id>', methods=['GET'])
def get_by_id(id):
    cursor.execute("SELECT * FROM ingredient WHERE id = %s", (id,))
    ingredient = cursor.fetchone()

    if ingredient:
        return jsonify(ingredient), 200
    else:
        jsonify({"message": "Ingredient not found!"}), 404

@ingredients_bp.route('/create', methods=['POST'])
def create():
    data = request.json

    title = data.get('title')
    description = data.get('description')
    default_unit_id = data.get('default_unit_id')

    try:
        cursor.execute(
            "INSERT INTO ingredient (title, description, default_unit_id) VALUES (%s, %s, %s)",
            (title, description, default_unit_id)
        )
        conn.commit()

        ingredient_id = cursor.lastrowid  

        cursor.execute(
            
        )

        return jsonify({
            "message": "Ingrediente cadastrado com sucesso!",
            "recipe": {
                "id": ingredient_id,
                "title": title,
                "description": description,
                "default_unit_id": default_unit_id
            }
        }), 201
    except Exception as e:
        print(f"Erro ao tentar cadastrar o ingrediente: {e}")
        return jsonify({"error": "Erro ao cadastrar o ingrediente, tente novamente!"}), 500

@ingredients_bp.route('/update/<int:id>', methods=['PUT'])
def update(id):
    data = request.json
    if data:
        title = data.get('title')
        description = data.get('description')
        default_unit_id = data.get('default_unit_id')

        cursor.execute("UPDATE ingredient SET title = %s, description = %s, default_unit_id = %s WHERE id = %s"
                       ,(title, description, default_unit_id, id))
        conn.commit()
        return jsonify({"message": "Updated"}, 200)
    else:
        return jsonify({"message": "Ingredient not found!"}, 404)

@ingredients_bp.route('/delete/<int:id>', methods=['DELETE'])
def delete(id):
    try:
        cursor.execute(
            "DELETE FROM ingredient WHERE id = %s",
            (id,)
        )
        conn.commit()
        return jsonify({"message": "Deleted"}), 204 
    except Exception as e:
        return jsonify({"error": "Erro ao deletar o ingrediente!"}), 500