package com.example.android_practice.webServices.api


/** This is for Practice in Background Thread Now we Use Coroutines for that work */

/***  This is for check Asyns Task
 *
 *
 *
 *
class NetworkAsyncCall(private val context: Context, private val url: String, private val requestType:
String, private val postJSONObject: JSONObject = JSONObject()
) : AsyncTask<String?, String?, String?>() {

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg p0: String?): String? {
        return when (requestType) {
            RequestHandler.GET -> RequestHandler.requestGET(url)
            RequestHandler.POST -> RequestHandler.requestPOST(url, postJSONObject)
            else -> ""
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onPostExecute(s: String?) {
        if (s != null) {
            Toast.makeText(context, s, Toast.LENGTH_LONG).show()
        }
    }
}
 */