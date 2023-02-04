package com.onlinecontactbook

class Contact {

    Integer id
    String name
    String image
    Member member

    Date dateCreated
    Date lastUpdated

    Set<ContactDetails> contactDetails
    Set<ContactGroup> contactGroup


    static hasMany = [contactDetails: ContactDetails, contactGroup: ContactGroup]

    static constraints = {
        image(nullable: true, blank: true)
    }
//If contact deleted all contact details will be deleted
    static mapping = {
        version(false)
        contactDetails(cascade: 'all-delete-orphan')
    }
}