// Used to control/manage the admin template. Detects bindings and manipulates the DOM.

(function () {
    let $rowTemplate;
    let $tbody;
    let $createBtn, $removeBtn, $editBtn, $updateBtn;
    let $firstNameInput, $lastNameInput, $roleInput, $usernameInput, $passwordInput;
    let selectedUserId;
    let selectedUser = {};
    let users = [];

    const userService = new UserService();

    $(main);

    function main() {
        $tbody = $('tbody');

        $rowTemplate = $('.wbdv-template');
        $createBtn = $('.wbdv-create');
        $updateBtn = $('.wbdv-update')

        $usernameInput = $('#usernameFld');
        $passwordInput = $('#passwordFld');
        $firstNameInput = $('#firstNameFld');
        $lastNameInput = $('#lastNameFld');
        $roleInput = $('#roleFld');

        $createBtn.click(createUser);
        $updateBtn.click(function () {
            // Validate a user has been selected to update.
            if (typeof (selectedUserId) !== 'undefined') {
                // findUserById(selectedUserId);
                updateUser();
            } else {
                alert('Please select a user to edit first.')
                __clearFields();
            }
            // After selecting a user, editing, and updating, reset back to undefined for next call.
            // https://stackoverflow.com/questions/5795936/how-to-set-a-javascript-var-as-undefined/24748543#24748543
            selectedUserId = void 0;
        });

        findAllUsers()
    }

    /**
     * Called on page load to find all users and render.
     */
    function findAllUsers() {
        userService.findAllUsers()
            .then(allUsers => {
                users = allUsers;
                renderUsers(users);
            })
    }

    /**
     * Receives userId from editBtn for current user.
     * Promise to server to find a guaranteed match.
     * Callback to translate from Java obj to JSON.
     * @param userToEditId
     */
    function findUserById(userToEditId) {
        userService
            .findUserById(userToEditId)
            .then(_setUserToReplace)
    }

    /**
     * Gets a returned user object in JSON from the server.
     * This user object is the one to be replaced/updated.
     * Populates the top bar with the selected server user values.
     * @param userFromServer
     * @private
     */
    function _setUserToReplace(userFromServer) {
        selectedUser = userFromServer;
        $usernameInput.val(userFromServer.username);
        $firstNameInput.val(userFromServer.firstName);
        $lastNameInput.val(userFromServer.lastName);
        $passwordInput.val(userFromServer.password);
        $roleInput.val(userFromServer.userRole);
    }

    /**
     * Renders all users after finding them.
     * @param users
     */
    function renderUsers(users) {
        $tbody.empty()
        for (let u in users) {
            const user = users[u]
            const rowClone = $rowTemplate.clone();
            rowClone.removeClass('wbdv-hidden');
            rowClone.find('.wbdv-username').html(user.username);
            rowClone.find('.wbdv-password').html("******");
            rowClone.find('.wbdv-first-name').html(user.firstName);
            rowClone.find('.wbdv-last-name').html(user.lastName);
            rowClone.find('.wbdv-role').html(user.userRole);

            rowClone.find('.wbdv-remove').attr("id", user._id).click(deleteUser);
            rowClone.find('.wbdv-edit').attr("id", user._id).click(selectUser);
            $tbody.append(rowClone);
        }
    }

    function createUser() {
        let username;
        let password;
        let firstname;
        let lastname;
        let role;

        if (__fieldsIsEmpty() === false) {
            username = $usernameInput.val();
            password = $passwordInput.val();
            firstname = $firstNameInput.val();
            lastname = $lastNameInput.val();
            role = $roleInput.val();

            let user = {
                username: username,
                password: password,
                firstName: firstname,
                lastName: lastname,
                userRole: role
            }
            userService
                .createUser(user)
                .then(newUser => {
                    users.push(newUser);
                    renderUsers(users)
                })
            __clearFields();
        } else {
            alert('You have empty fields!');
        }
    }

    function deleteUser(event) {
        const target = $(event.currentTarget);
        $removeBtn = $(target);
        let userId = $removeBtn.attr("id");
        console.log("userId: " + userId);
        userService
            .deleteUser(userId)
            .then(() => {
                users = users.filter(user => user._id !== userId);
                renderUsers(users)
            })
        alert(`User ${userId} removed!`);
    }

    /**
     * Listens for a click event on the editBtn.
     * Callback for userId to service -> server to find a guaranteed match.
     * @param event
     */
    function selectUser(event) {
        const target = $(event.currentTarget);
        $editBtn = $(target);
        selectedUserId = $editBtn.attr("id");
        alert(`User ${selectedUserId} selected!`);
        findUserById(selectedUserId);
    }

    function updateUser() {
        if (__fieldsIsEmpty() === false) {
            let updatedUser = {
                _id: selectedUser._id,
                username: $usernameInput.val(),
                password: $passwordInput.val(),
                firstName: $firstNameInput.val(),
                lastName: $lastNameInput.val(),
                userRole: $roleInput.val()
            };
            userService
                .updateUser(selectedUser._id, updatedUser)
                .then(function () {
                    users = users.map(user => {
                        if (user._id === selectedUser._id) {
                            return updatedUser
                        } else {
                            return user
                        }
                    });
                    renderUsers(users)
                    __clearFields();
                })
        } else {
            alert('You have empty fields!');
        }
    }

    function __fieldsIsEmpty() {
        return $usernameInput.val().length === 0 || $firstNameInput.val().length === 0
            || $lastNameInput.val().length === 0 || $roleInput.val().length === 0 || !$passwordInput.val().trim();
    }

    /**
     * https://stackoverflow.com/questions/6364289/clear-form-fields-with-jquery
     * @private
     */
    function __clearFields() {
        $(':input').not(':button, :submit, :reset, :hidden')
            .removeAttr('checked').removeAttr('selected')
            .not(':checkbox, :radio, select').val('');
    }

})();