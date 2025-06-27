from flask import url_for, jsonify, Blueprint, request
from app.connection import conn
from werkzeug.security import check_password_hash

auth_bp = Blueprint('auth', __name__)

@auth_bp.route('/login', methods=['GET', 'POST'])
def login():
    
    if request.method == "GET":
        return jsonify({"message": "Digite seu email e senha"})
    elif request.method == "POST":
        data = request.json
        email = data.get("email")
        password = data.get("password")

        cursor = conn.cursor(dictionary=True)

        try:
            cursor.execute(
                "SELECT id, email, password FROM user WHERE email = %s AND password = %s",
                (email, password)
            )
            user = cursor.fetchone()

            if(user):
                return jsonify({"message": "bem vindo!", "user": {
                    "id": user["id"],
                    "email": user["email"],
                    "password": user["password"]
                }
                }, 200)
            else:
                return jsonify({"error": "Usuário não encontrado."}), 500
        except Exception as e:
            print(f"Erro ao inserir usuário: {e}")
            return jsonify({"error": "ocorreu um erro."}), 500


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