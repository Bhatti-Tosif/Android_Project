package com.example.android_practice.webServices.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.android_practice.databinding.FragmentAddUserBinding
import com.example.android_practice.webServices.Utils.AppConstant
import com.example.android_practice.webServices.factory.UserViewModelFactory
import com.example.android_practice.webServices.model.UserModel
import com.example.android_practice.webServices.viewModel.UserViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Locale


class AddUserFragment : DialogFragment() {

    private lateinit var binding: FragmentAddUserBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var imageUri: Uri

    @SuppressLint("Recycle")
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddUserBinding.inflate(inflater, container, false)
        userViewModel = ViewModelProvider(
            this,
            UserViewModelFactory(AppConstant.userRepository)
        )[UserViewModel::class.java]
        imageUri = Uri.parse("")

        binding.ivProfilePic.setOnClickListener {
            checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        binding.btnAddUser.setOnClickListener {
            val user = UserModel(
                Locale.US.toString(),
                binding.etName.text.toString(),
                imageUri.toString(),
                binding.etEmail.text.toString(),
                ""
            )
            GlobalScope.launch {
                userViewModel.createUser(user)
            }
            dismiss()
        }

        return binding.root
    }

    /** Practice for uploaing Image
    @SuppressLint("Recycle")
    private fun uploadImage() {
    val fileDir = activity?.filesDir
    val file = File(fileDir, "image.png")
    val inputStream = activity?.contentResolver?.openInputStream(imageUri)
    val outputStream = FileOutputStream(file)
    inputStream?.copyTo(outputStream)

    val requestBody = file.
    }  */

    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.ivProfilePic.setImageURI(it)
        it?.let { imageUri = it }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun checkPermission(permission: String) {
        if (context?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    permission
                )
            } == PackageManager.PERMISSION_GRANTED) {
            contract.launch("image/*")
        } else if (context?.let { ActivityCompat.checkSelfPermission(it, permission) } == PackageManager.PERMISSION_DENIED)  {
            openAlertDialog()
        } else {
            requestMultiplePermissionLauncher.launch(permission)
        }
    }

    private val requestMultiplePermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
            if (result) {
                Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
                contract.launch("image/*")

            } else {
                openAlertDialog()
            }
        }

    private fun openAlertDialog() {
        val builder = AlertDialog.Builder(context)
        builder.apply {
            setMessage("This Permission Required for take a image")
            setTitle("Permission Required!")
        }
        builder.setPositiveButton("Yes") { _, _ ->
            requestMultiplePermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        val alertDialog = builder.create()
        alertDialog.show()
    }
}