package com.pwhs.quickmem.presentation.app.home

sealed class HomeUIEvent {
    object OpenSearch : HomeUIEvent()
    object OpenFreeTrial : HomeUIEvent()
    object SaveSets : HomeUIEvent()
    object ViewAllSets : HomeUIEvent()
    object DetailSets : HomeUIEvent()
    object ViewMoreSets : HomeUIEvent()
    object SaveFolder : HomeUIEvent()
    object ViewAllFolder : HomeUIEvent()
    object DetailFolder : HomeUIEvent()
    object CreateFlashcard : HomeUIEvent()
    object FindTopic : HomeUIEvent()
}