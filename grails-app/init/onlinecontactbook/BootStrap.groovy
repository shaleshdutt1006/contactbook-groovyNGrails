package onlinecontactbook

import com.onlinecontactbook.AppInitializationService
class BootStrap {

    def init = { servletContext ->
    //This will call automatically when application is start
    AppInitializationService.initialize()
    }
    def destroy = {
    }
}
