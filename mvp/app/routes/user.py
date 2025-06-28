from flask import url_for, jsonify, Blueprint, request
from app.connection import conn
from werkzeug.security import check_password_hash

users_bp = Blueprint('users', __name__)

cursor = conn.cursor(dictionary=True)

@users_bp.route('/', methods=['GET'])
def get_all():
    cursor.execute("SELECT * FROM user")
    users = cursor.fetchall()

    return jsonify(users), 200

@users_bp.route('/<int:id>', methods=['GET'])
def get_by_id(id):
    cursor.execute("SELECT * FROM user WHERE id = %s", (id,))
    user = cursor.fetchone()

    if user:
        return jsonify(user), 200
    else:
        jsonify({"message": "User not found."}), 404

@users_bp.route('/create', methods=['POST'])
def create():
    data = request.json

    name = data.get('name')
    email = data.get('email')
    password = data.get('password')

    try:
        cursor.execute(
            "INSERT INTO user (name, password, email) VALUES (%s, %s, %s)",
            (name, password, email)
        )
        conn.commit()

        user_id = cursor.lastrowid  # ID do novo usuário

        return jsonify({
            "message": "Usuário cadastrado com sucesso!",
            "usuario": {
                "id": user_id,
                "name": name,
                "email": email
            }
        }), 201

    except Exception as e:
        print(f"Erro ao inserir usuário: {e}")
        return jsonify({"error": "Erro ao criar usuário. Tente novamente!"}), 500


@users_bp.route('/update/<int:id>', methods=['PUT'])
def update(id):
    data = request.json
    if data:
        # cursor.execute("SELECT * FROM user WHERE id = %s", (id))
        # user = cursor.fetchone()
        name = data.get('name')
        email = data.get('email')
        password = data.get('password')
        avatar_url = "" if not data.get('avatar_url') else data.get('avatar_url')

        cursor.execute("UPDATE user SET name = %s, email = %s, password = %s, avatar_url = %s WHERE id = %s"
                       ,(name, email, password, avatar_url, id))
        conn.commit()
        return jsonify({"message": "Updated"}, 200)
    else:
        return jsonify({"message": "User not found!"}, 404)

@users_bp.route('/delete/<int:id>', methods=['DELETE'])
def delete(id):
    try:
        cursor.execute(
            "DELETE FROM user WHERE id = %s",
            (id,)
        )
        conn.commit()
        return jsonify({"message": "Deleted"}), 204 
    except Exception as e:
        print(f"Erro ao deletar usuário: {e}")
        return jsonify({"error": "Erro ao deletar usuário!"}), 500