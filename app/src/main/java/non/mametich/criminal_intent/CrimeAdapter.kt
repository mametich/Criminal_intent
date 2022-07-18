package non.mametich.criminal_intent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CrimeAdapter(private var crimes: List<Crime>) : RecyclerView.Adapter<CrimeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item_crime, parent,false)
        return CrimeHolder(view)
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

    override fun getItemCount(): Int {
        return crimes.size
    }
}

class CrimeHolder(view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var crime: Crime

    private val titleTextView: TextView = itemView.findViewById(R.id.crime_title)
    private val dateTextView: TextView = itemView.findViewById(R.id.crime_date)
    private val solvedImageView: ImageView = itemView.findViewById(R.id.crime_solved)

    fun bind(crime: Crime){
        this.crime = crime
        titleTextView.text = crime.title
        dateTextView.text = crime.date.toString()
        solvedImageView.visibility = if(crime.isSolved){
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}
