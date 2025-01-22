package com.surivalcoding.composerecipeapp.core.presentation

interface ViewCommandable<VE : ViewEventable, VM: ViewModelable<*, *>> {
     fun execute(event: VE, vm: VM)
}