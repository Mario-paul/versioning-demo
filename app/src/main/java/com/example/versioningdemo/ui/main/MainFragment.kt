package com.example.versioningdemo.ui.main

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.versioningdemo.R
import com.example.versioningdemo.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        return inflater.inflate(R.layout.fragment_main, container, false)

        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)

        getApplicationVersion()

        return binding.root
    }

    /**
     * Get application version and display it in the UI
     */
    private fun getApplicationVersion() {
////        Get app version from build.gradle
//        val versionName = BuildConfig.VERSION_NAME
//        val versionCode = BuildConfig.VERSION_CODE

//         Or, get app version from Android OS
        val versionName = context?.packageManager?.getPackageInfo(
            requireContext().packageName,
            PackageManager.GET_ACTIVITIES
        )?.versionName

////         Or, get app code from Android OS
//        val versionCode = context?.packageManager?.getPackageInfo(
//            requireContext().packageName,
//            PackageManager.GET_ACTIVITIES
//        )?.longVersionCode // minimum API level 28

//         Or, get app code from Android OS
        val versionCode = context?.packageManager?.getPackageInfo(
            requireContext().packageName,
            PackageManager.GET_ACTIVITIES
        )?.versionCode

//        Set app version into textView
        binding.textViewVersionName.text = getString(R.string.application_version, versionName)
        binding.textViewVersionCode.text = getString(R.string.application_code, versionCode)
    }

}