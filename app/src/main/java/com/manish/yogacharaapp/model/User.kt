package com.manish.yogacharaapp.model

class User{
    var name:String?=null
    var email:String?=null
    var uid:String?=null
    var phone:String?=null

    constructor(){}

    constructor(name :String?,email:String?,phone:String?,uid:String?)
    {
        this.name=name
        this.email=email
        this.phone=phone
        this.uid=uid
    }
}
