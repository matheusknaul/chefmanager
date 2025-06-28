class User:
    def __init__(self, name, email, password):
        self._name = name
        self._email = email
        self._passwrod = password

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, new_name):
        if not new_name:
            raise ValueError("O nome não pode ser vazio!")
        self._name = new_name
    
    @property
    def email(self):
        return self._name

    @email.setter
    def email(self, new_name):
        if not new_name:
            raise ValueError("O email não pode estar vazio!")
        self._name = new_name

    @property
    def password(self):
        return self._name

    @password.setter
    def password(self, new_name):
        if not new_name:
            raise ValueError("A senha não pode estar vazia!")
        self._name = new_name