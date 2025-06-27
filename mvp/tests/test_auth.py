import pytest

@pytest.mark.parametrize("email, password, expected_status", [
    ("mathesus@knsaual.com", "123", 200),
    ("user_dont_existis", "123", 500),
    ("", "", 500),
])

def test_login(client, email, password, expected_status):
    response = client.post('/auth/login', json={
        "email": email,
        "password": password
    })
    assert response.status_code == expected_status