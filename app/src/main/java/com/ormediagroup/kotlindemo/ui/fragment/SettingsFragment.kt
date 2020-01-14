package com.ormediagroup.kotlindemo.ui.fragment

import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.ormediagroup.kotlindemo.R
import org.jetbrains.anko.support.v4.toast

/**
 * Created by Lau on 2020-01-14.
 */
class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.settings)
    }

    override fun onPreferenceTreeClick(preference: Preference?): Boolean {
        var key = preference?.key
        when (key) {
            "about" -> {
                toast("click about")
            }
        }
        return super.onPreferenceTreeClick(preference)
    }
}