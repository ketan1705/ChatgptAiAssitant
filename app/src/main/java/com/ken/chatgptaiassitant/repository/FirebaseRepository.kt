package com.ken.chatgptaiassitant.repository

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.ken.chatgptaiassitant.models.ChatModel
import com.ken.chatgptaiassitant.utils.Constant.TAG
import javax.inject.Inject


class FirebaseRepository @Inject constructor(val firebase: FirebaseFirestore) {

    val documentReference = firebase.collection("chats").document("chat_document_id")

    suspend fun loadMessage() {

    }

    suspend fun saveMessage(chatModel: ChatModel) {
        documentReference.get().addOnSuccessListener { document ->
            {
                if (document.exists()) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                    val currentMessage =
                        document.toObject<ChatModel>(ChatModel::class.java)
                }
            }
        }

    }

}