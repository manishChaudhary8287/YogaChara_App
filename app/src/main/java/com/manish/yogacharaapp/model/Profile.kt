package com.manish.yogacharaapp.model

class Profile{
    var name:String?=null
    var email:String?=null
    var uid:String?=null
    var phone:String?=null
    var age:String?=null
    var weight:String?=null
    var height:String?=null

    constructor(){}

    constructor(name :String?,email:String?,phone:String?,age:String,weight:String,height:String,uid:String?)
    {
        this.name=name
        this.email=email
        this.phone=phone
        this.age=age
        this.weight=weight
        this.height=height
        this.uid=uid
    }
}
