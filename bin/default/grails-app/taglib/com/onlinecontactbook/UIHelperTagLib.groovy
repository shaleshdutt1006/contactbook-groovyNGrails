package com.onlinecontactbook

class UIHelperTagLib {

    static namespace = "UIHelper"

    AuthenticationService authenticationService
ContactGroupService contactGroupService
    def renderErrorMessage = { attrs, body ->
        def model = attrs.model
        String fieldName = attrs.fieldName
        String errorMessage = attrs.errorMessage? g.message(code: attrs.errorMessage): g.message(code: "invalid.input")
        if (model && model.errors && model.errors.getFieldError(fieldName)){
            out << "<small class='form-text text-danger''><strong>${errorMessage}</strong></small>"
        }
    }

//Method to show the name of the member which is logged in
    def memberActionMenu = { attrs, body ->
        out << '<li class="nav-item dropdown show">'
        out << g.link(class:"nav-link dropdown-toggle", "data-toggle":"dropdown"){authenticationService.getMemberName()}
        out << '<div class="dropdown-menu">'
        out << g.link(controller: "authentication", action: "logout", class: "dropdown-item"){g.message(code:"logout")}
        out << "</div></li>"
    }

//Adding tag lib for left side navigation buttons they are empty without it
    def leftNavigation = { attrs, body ->
        List navigations = [
                [controller: "dashboard", action: "index", name: "dashboard"],

               //Adding  contact group to the left side navigation
                [controller: "contactGroup", action: "index", name: "contact.group"],

                [controller: "contact", action: "index", name: "contact"],
        ]

        if(authenticationService.isAdministratorMember()){
            navigations.add([controller: "member", action: "index", name: "member"])
        }

        navigations.each { menu ->
            out << '<li class="list-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { g.message(code: menu.name, args: ['']) }
            out << '</li>'
        }
    }
    
    def contactGroup = { attrs, body ->
        String name = attrs.name ?: "contactGroup"
        out << g.select(class:"form-control", multiple: "multiple", optionValue: "name", optionKey: "id", value: attrs.value, name: name, from: contactGroupService.getGroupList())
    }

}