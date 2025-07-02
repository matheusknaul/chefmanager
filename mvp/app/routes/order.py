from flask import url_for, jsonify, Blueprint, request
from app.connection import conn
from werkzeug.security import check_password_hash

orders_bp = Blueprint('orders', __name__)

cursor = conn.cursor(dictionary=True)

@orders_bp.route('/', methods=['GET'])
def get_all():
    cursor.execute("SELECT * FROM order_app")
    orders = cursor.fetchall()

    return jsonify(orders), 200

@orders_bp.route('/<int:id>', methods=['GET'])
def get_by_id(id):
    cursor.execute("SELECT * FROM order_app WHERE id = %s", (id,))
    order = cursor.fetchone()

    if order:
        return jsonify(order), 200
    else:
        jsonify({"message": "Order not found."}), 404

@orders_bp.route('/create', methods=['POST'])
def create():
    #TODO: Criar tabela order_receita e cadastrar as receitas nesse endpoint também
    data = request.json

    user_id = data.get('user_id')
    description = data.get('description')

    try:
        cursor.execute(
            "INSERT INTO order_app (user_id, description) VALUES (%s, %s)",
            (user_id, description)
        )
        conn.commit()

        order_id = cursor.lastrowid  

        return jsonify({
            "message": "Pedido feito com sucesso!",
            "recipe": {
                "id": order_id,
                "user_id": user_id,
                "description": description
            }
        }), 201

    except Exception as e:
        print(f"Erro ao tentar cadastrar o pedido: {e}")
        return jsonify({"error": "Erro ao cadastrar o pedido, tente novamente!"}), 500


@orders_bp.route('/update/<int:id>', methods=['PUT'])
def update(id):
    data = request.json
    if data:
        description = data.get('description')

        cursor.execute("UPDATE order_app SET description = %s WHERE id = %s"
                       ,(description, id))
        conn.commit()
        return jsonify({"message": "Updated"}, 200)
    else:
        return jsonify({"message": "Order not found!"}, 404)

@orders_bp.route('/delete/<int:id>', methods=['DELETE'])
def delete(id):
    try:
        cursor.execute(
            "DELETE FROM order_app WHERE id = %s",
            (id,)
        )
        conn.commit()
        return jsonify({"message": "Deleted"}), 204 
    except Exception as e:
        return jsonify({"error": "Erro ao deletar o pedido!"}), 500