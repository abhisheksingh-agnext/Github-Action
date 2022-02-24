package com.agnext.githubaction

object AppStates {
    /**Login Screen*/
    const val LOGIN_ERROR = "LOGIN_ERROR"
    const val LOGIN_SUCCESS = "LOGIN_SUCCESS"

    /**Landing screen*/
    const val SAMPLE_ID_SUCCESS = "SAMPLE_ID_SUCCESS"
    const val SAMPLE_ID_ERROR = "SAMPLE_ID_ERROR"

    /**Assay screen*/
    const val ASSAY_SUCCESS = "ASSAY_SUCCESS"
    const val ASSAY_ERROR = "ASSAY_ERROR"

    /**Home Screen*/
    const val USER_LOADING = "USER_LOADING"
    const val USER_SUCCESS = "USER_SUCCESS"
    const val USER_ERROR = "USER_ERROR"

    /**History Screen*/
    const val HISTORY_SUCCESS = "HISTORY_SUCCESS"
    const val HISTORY_ERROR = "HISTORY_ERROR"
}