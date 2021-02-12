function UserService() {

    // Expose the function throw an instance of UserService
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.createUser = createUser;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/001310994/users';
    var self = this;


    // CREATE - POST
    // sends stringified json data to server to be parsed from string to obj.
    // receives from promise, a response from server to json.
    function createUser(user) {
        return fetch(self.url, {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function (response) {
            return response.json()
        })
    }

    // READ - GET
    function findAllUsers() {
        return fetch(self.url)
            .then(function (response) {
                return response.json()
            })
    }

    // READ - GET
    function findUserById(id) {
        return fetch(self.url + `/${id}`, {
        }).then(function (response) {
            return response.json()
        })
    }

    function updateUser(id, user) {
        return fetch(self.url + `/${id}`, {
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function (response) {
            return response.json()
        })
    }

    // DELETE - DELETE
    function deleteUser(id) {
        return fetch(self.url + `/${id}`, {
            method: 'DELETE'
        }).then(function (response) {
            return response.json()
        })
    }
}