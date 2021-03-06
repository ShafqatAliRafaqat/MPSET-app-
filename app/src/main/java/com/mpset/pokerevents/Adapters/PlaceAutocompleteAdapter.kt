package com.mpset.pokerevents.Adapters


import android.content.Context
import android.graphics.Typeface
import android.text.style.StyleSpan
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.common.api.GoogleApiClient

import com.google.android.gms.common.data.DataBufferUtils
import com.google.android.gms.location.places.AutocompleteFilter
import com.google.android.gms.location.places.AutocompletePrediction
import com.google.android.gms.location.places.AutocompletePredictionBufferResponse
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.tasks.RuntimeExecutionException
import com.google.android.gms.tasks.Tasks

import java.util.ArrayList
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

///**
// * Adapter that handles Autocomplete requests from the Places Geo Data Client.
// * [AutocompletePrediction] results from the API are frozen and stored directly in this
// * adapter. (See [AutocompletePrediction.freeze].)
// */
//class PlaceAutocompleteAdapter
///**
// * Initializes with a resource for text rows and autocomplete query bounds.
// *
// * @see android.widget.ArrayAdapter.ArrayAdapter
// */
//(context: Context,
// /**
//  * Handles autocomplete requests.
//  */
// private val mGeoDataClient: GoogleApiClient?,
// /**
//  * The bounds used for Places Geo Data autocomplete API requests.
//  */
// private var mBounds: LatLngBounds?,
// /**
//  * The autocomplete filter used to restrict queries to a specific set of place types.
//  */
// private val mPlaceFilter: AutocompleteFilter?) : ArrayAdapter<AutocompletePrediction>(context, android.R.layout.simple_expandable_list_item_2, android.R.id.text1), Filterable {
//    /**
//     * Current results returned by this adapter.
//     */
//    private var mResultList: ArrayList<AutocompletePrediction>? = null
//
//    /**
//     * Sets the bounds for all subsequent queries.
//     */
//    fun setBounds(bounds: LatLngBounds) {
//        mBounds = bounds
//    }
//
//    /**
//     * Returns the number of results received in the last autocomplete query.
//     */
//    override fun getCount(): Int {
//        return mResultList!!.size
//    }
//
//    /**
//     * Returns an item from the last autocomplete query.
//     */
//    override fun getItem(position: Int): AutocompletePrediction? {
//        return mResultList!![position]
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        val row = super.getView(position, convertView, parent)
//
//        // Sets the primary and secondary text for a row.
//        // Note that getPrimaryText() and getSecondaryText() return a CharSequence that may contain
//        // styling based on the given CharacterStyle.
//
//        val item = getItem(position)
//
//        val textView1 = row.findViewById<View>(android.R.id.text1) as TextView
//        val textView2 = row.findViewById<View>(android.R.id.text2) as TextView
//        textView1.setText(item!!.getPrimaryText(STYLE_BOLD))
//        textView2.setText(item!!.getSecondaryText(STYLE_BOLD))
//
//        return row
//    }
//
//    /**
//     * Returns the filter for the current set of autocomplete results.
//     */
//    override fun getFilter(): Filter {
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence?): Filter.FilterResults {
//                val results = Filter.FilterResults()
//
//                // We need a separate list to store the results, since
//                // this is run asynchronously.
//                var filterData: ArrayList<AutocompletePrediction>? = ArrayList<AutocompletePrediction>()
//
//                // Skip the autocomplete query if no constraints are given.
//                if (constraint != null) {
//                    // Query the autocomplete API for the (constraint) search string.
//                    filterData = getAutocomplete(constraint)
//                }
//
//                results.values = filterData
//                if (filterData != null) {
//                    results.count = filterData.size
//                } else {
//                    results.count = 0
//                }
//
//                return results
//            }
//
//            override fun publishResults(constraint: CharSequence, results: Filter.FilterResults?) {
//
//                if (results != null && results.count > 0) {
//                    // The API returned at least one result, update the data.
//                    mResultList = results.values as ArrayList<AutocompletePrediction>
//                    notifyDataSetChanged()
//                } else {
//                    // The API did not return any results, invalidate the data set.
//                    notifyDataSetInvalidated()
//                }
//            }
//
//            override fun convertResultToString(resultValue: Any): CharSequence {
//                // Override this method to display a readable result in the AutocompleteTextView
//                // when clicked.
//                return if (resultValue is AutocompletePrediction) {
//                    (resultValue as AutocompletePrediction).getFullText(null)
//                } else {
//                    super.convertResultToString(resultValue)
//                }
//            }
//        }
//    }
//
//    private fun getAutocomplete(constraint: CharSequence): ArrayList<AutocompletePrediction>? {
////        Log.i(TAG, "Starting autocomplete query for: $constraint")
//
//        // Submit the query to the autocomplete API and retrieve a PendingResult that will
//        // contain the results when the query completes.
//        val results = mGeoDataClient.getAutocompletePredictions(constraint.toString(), mBounds,
//                mPlaceFilter)
//
//        // This method should have been called off the main UI thread. Block and wait for at most
//        // 60s for a result from the API.
//        try {
//            Tasks.await<AutocompletePredictionBufferResponse>(results, 60, TimeUnit.SECONDS)
//        } catch (e: ExecutionException) {
//            e.printStackTrace()
//        } catch (e: InterruptedException) {
//            e.printStackTrace()
//        } catch (e: TimeoutException) {
//            e.printStackTrace()
//        }
//
//        try {
//            val autocompletePredictions = results.getResult()
//
////            Log.i(TAG, "Query completed. Received " + autocompletePredictions!!.getCount()
////                    + " predictions.")
//
//            // Freeze the results immutable representation that can be stored safely.
//            return DataBufferUtils.freezeAndClose(autocompletePredictions!!)
//        } catch (e: RuntimeExecutionException) {
//            // If the query did not complete successfully return null
//            Toast.makeText(context, "Error contacting API: " + e.toString(),
//                    Toast.LENGTH_SHORT).show()
////            Log.e(TAG, "Error getting autocomplete prediction API call", e)
//            return null
//        }
//
//    }
//
//    companion object {
//
//        private val TAG = "PlaceAutocompleteAdapter"
//        private val STYLE_BOLD = StyleSpan(Typeface.BOLD)
//    }
//}