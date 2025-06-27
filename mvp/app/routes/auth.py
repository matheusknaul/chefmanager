from flask import url_for, jsonify, Blueprint, request
from connection import conn
from werkzeug.security import check_password_hash

auth_bp = Blueprint('auth', __name__)

@auth_bp.route('/login', methods=['GET'])
def login():
    return jsonify(
        {
            "message": "Login"
        }, 200
    )

@auth_bp.route('/register', method=['POST'])
def register():

    data = request.json

    name = data.get('name')
    email = data.get('email')
    password = data.get('password')

    cursor = conn.cursor(dictionary=True)

    cursor.execute(f'INSERT INTO user (name, password, email) values ({name}, {password}, {email});')

    signal = cursor.fetchone()

    id_new_user = cursor.execute(f'SELECT id FROM user WHERE name, email LIKE {name}, {email};')

    

    if signal:
        return jsonify(
            {
                "message": "Usuário cadastrado com sucesso!",
                "usuário":{

                }
            }, 201
        )


    return "a"