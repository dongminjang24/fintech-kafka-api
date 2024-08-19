package com.fintech.com.fintech.domain


import javax.persistence.*;

@Entity
@Table(name = "USR_INFO")
class UserInfo(
    // kotlin("plugin.jpa") 때문에 초기값을 안넣어줘도 된다.
    @Column(name = "usr_key")
    val userKey: String,

    @Column(name = "usr_reg_num")
    val userRegistrationNumber: String,

    @Column(name = "usr_nm")
    val userName: String,

    @Column(name = "usr_icm_amt")
    val userIncomeAmount: Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}