from flask import url_for, jsonify, Blueprint, request
from app.connection import conn
from werkzeug.security import check_password_hash

auth_bp = Blueprint('auth', __name__)

@auth_bp.route('/login', methods=['GET'])
def login():
    return jsonify(
        {
            "message": "Login"
        }, 200
    )

@auth_bp.route('/register', methods=['POST'])
def register():

    data = request.json

    name = data.get('name')
    email = data.get('email')
    password = data.get('password')

    cursor = conn.cursor(dictionary=True)

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