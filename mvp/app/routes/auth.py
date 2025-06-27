from flask import url_for, jsonify, Blueprint

auth_bp = Blueprint('auth', __name__)

@auth_bp.route('/login', methods=['GET'])
def login():
    return jsonify(
        {
            "message": "Login"
        }, 200
    )