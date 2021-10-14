package com.geekbrains.tests

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.view.details.ViewDetailsContract
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.junit.Assert.*

class DetailsPresenterTest {

    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailsPresenter()
        presenter.onAttach(viewContract)
    }

    @Test
    fun viewContractNotNull_Test() {
        assertNotNull(presenter.viewContract)
    }

    @Test
    fun onAttach_Test() {
        assertEquals(viewContract, presenter.viewContract)
    }

    @Test
    fun onDetach_Test() {
        presenter.onDetach()
        assertNull(presenter.viewContract)
    }

    @Test
    fun onIncrement_Test() {
        presenter.onIncrement()
        verify(viewContract, Mockito.times(1)).setCount(1)
    }

    @Test
    fun onDecrement_Test() {
        presenter.onDecrement()
        verify(viewContract, Mockito.times(1)).setCount(-1)
    }

    @Test
    fun setCounter_Test() {
        presenter.setCounter(2)
        presenter.onIncrement()
        verify(viewContract, Mockito.times(1)).setCount(3)
    }

}