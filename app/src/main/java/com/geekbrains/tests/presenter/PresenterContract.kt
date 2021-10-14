package com.geekbrains.tests.presenter

import com.geekbrains.tests.view.ViewContract

internal interface PresenterContract<T:ViewContract> {
    fun onAttach(view: T)
    fun onDetach()
}
