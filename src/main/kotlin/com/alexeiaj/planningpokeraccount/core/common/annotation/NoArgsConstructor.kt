package com.alexeiaj.planningpokeraccount.core.common.annotation

import kotlin.annotation.AnnotationRetention.SOURCE
import kotlin.annotation.AnnotationTarget.CLASS

@Target(CLASS)
@Retention(SOURCE)
annotation class NoArgsConstructor
