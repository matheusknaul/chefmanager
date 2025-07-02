from flask import Flask

def create_app():
    app = Flask(__name__)

    from app.routes import auth_bp, users_bp, recipes_bp, orders_bp, ingredients_bp, units_bp
    app.register_blueprint(auth_bp, url_prefix='/auth')
    app.register_blueprint(users_bp, url_prefix='/users')
    app.register_blueprint(recipes_bp, url_prefix='/recipes')
    app.register_blueprint(orders_bp, url_prefix='/orders')
    app.register_blueprint(ingredients_bp, url_prefix='/ingredients')
    app.register_blueprint(units_bp, url_prefix='/units')
    
    return app