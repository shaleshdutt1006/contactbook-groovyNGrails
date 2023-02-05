package com.onlinecontactbook

class MemberInterceptor {

    AuthenticationService authenticationService
//If member is adminstrator return true else false
    boolean before() {
        if (authenticationService.isAdministratorMember()){
            return true
        }
        flash.message = AppUtil.infoMessage("You are not Authorized for this Action.", false)
        redirect(controller: "dashboard", action: "index")
        return false
    }
}