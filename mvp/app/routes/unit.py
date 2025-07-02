from flask import url_for, jsonify, Blueprint, request
from app.connection import conn
from werkzeug.security import check_password_hash

units_bp = Blueprint('units', __name__)

cursor = conn.cursor(dictionary=True)

@units_bp.route('/', methods=['GET'])
def get_all():
    cursor.execute("SELECT * FROM unit")
    units = cursor.fetchall()

    return jsonify(units), 200

@units_bp.route('/<int:id>', methods=['GET'])
def get_by_id(id):
    cursor.execute("SELECT * FROM unit WHERE id = %s", (id,))
    unit = cursor.fetchone()

    if unit:
        return jsonify(unit), 200
    else:
        jsonify({"message": "Unit not found."}), 404

@units_bp.route('/create', methods=['POST'])
def create():
    data = request.json

    title = data.get('title')
    symbol = data.get('symbol')
    type = data.get('type')

    try:
        cursor.execute(
            "INSERT INTO unit (title, symbol, type) VALUES (%s, %s, %s)",
            (title, symbol, type)
        )
        conn.commit()

        unit_id = cursor.lastrowid  

        return jsonify({
            "message": "Unidade de medida cadastrada com sucesso!",
            "recipe": {
                "id": unit_id,
                "title": title,
                "symbol": symbol,
                "type": type
            }
        }), 201

    except Exception as e:
        print(f"Erro ao cadastrar a unidade de medida: {e}")
        return jsonify({"error": "Erro ao cadastrar a unidade de medida. Tente novamente!"}), 500


@units_bp.route('/update/<int:id>', methods=['PUT'])
def update(id):
    data = request.json
    if data:
        title = data.get('tile')
        symbol = data.get('symbol')
        type = data.get('type')

        cursor.execute("UPDATE unit SET title = %s, symbol = %s, type = %s WHERE id = %s"
                       ,(title, symbol, type , id))
        conn.commit()
        return jsonify({"message": "Updated"}, 200)
    else:
        return jsonify({"message": "Unit not found!"}, 404)

@units_bp.route('/delete/<int:id>', methods=['DELETE'])
def delete(id):
    try:
        cursor.execute(
            "DELETE FROM unit WHERE id = %s",
            (id,)
        )
        conn.commit()
        return jsonify({"message": "Deleted"}), 204 
    except Exception as e:
        return jsonify({"error": "Erro ao deletar a unidade de medida!"}), 500