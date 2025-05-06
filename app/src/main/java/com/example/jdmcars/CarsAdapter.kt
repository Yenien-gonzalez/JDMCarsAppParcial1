package com.example.jdmcars

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CarsAdapter(val context: Context) : ListAdapter<Cars, CarsAdapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Cars) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val motor: TextView = view.findViewById(R.id.textViewMotor)
        private val modelo: TextView = view.findViewById(R.id.textViewModelo)
        private val hp: TextView = view.findViewById(R.id.textViewHp)
        private val kilogramos: TextView = view.findViewById(R.id.textViewKilogramos)
        private val imagenMarca: ImageView = view.findViewById(R.id.imageViewMarca)
        private val imagenCars: ImageView = view.findViewById(R.id.imageViewImagen)

        fun bind (cars: Cars) {
            motor.text = "Motor: " + cars.motor.toString()
            modelo.text = "Modelo: " + cars.modelo
            hp.text = "HP: " + cars.hp.toString()
            kilogramos.text = "KG: " + cars.kilogramos.toString()

            val image = when(cars.marca) {
                MarcaCars.MAZDA -> R.drawable.mazda
                MarcaCars.TOYOTA -> R.drawable.toyota
                MarcaCars.NISSAN -> R.drawable.nissan
                MarcaCars.HONDA -> R.drawable.honda
                MarcaCars.MITSUBISHI -> R.drawable.mitsubishi
            }

            imagenMarca.setImageResource(image)

            Glide.with(context)
                .load(cars.url)
                .into(imagenCars)

            view.setOnClickListener {
                onItemClickListener(cars)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarsAdapter.ViewHolder, position: Int) {
        val cars = getItem(position)
        holder.bind(cars)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Cars>() {
        override fun areItemsTheSame(oldItem: Cars, newItem: Cars): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cars, newItem: Cars): Boolean {
            return oldItem == newItem
        }
    }
}