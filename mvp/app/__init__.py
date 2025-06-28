from flask import Flask

def create_app():
    app = Flask(__name__)

    from app.routes import auth_bp, users_bp
    app.register_blueprint(auth_bp, url_prefix='/auth')
    app.register_blueprint(users_bp, url_prefix='/users')
    
    return app