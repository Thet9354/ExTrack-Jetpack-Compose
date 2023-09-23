package com.example.goodbyemoney

import com.example.goodbyemoney.models.Category
import com.example.goodbyemoney.models.Expense
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

val config = RealmConfiguration.create(schema = setOf(Expense::class, Category::class))
val db: Realm = Realm.open(config)