package com.pwhs.quickmem.presentation.app.home

sealed class HomeUIAction {
    object NavigateToSearch : HomeUIAction()
    object OpenFreeTrialPage : HomeUIAction()
}