package com.example.torang_detail.menureview

//abstract class MenuRatingRvAdt : RecyclerView.Adapter<MenuRatingHolder>() {
//    abstract fun clickMenu(menuBody: Menu, position: Int)
//    private var menuBodies: List<Menu>? = null
//    fun setMenuBodies(menuBodies: List<Menu>) {
//        this.menuBodies = menuBodies
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuRatingHolder {
//        return MenuRatingHolder(
//            ItemMenuRatingBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//    }
//
//    override fun onBindViewHolder(holder: MenuRatingHolder, position: Int) {
//        holder.itemMenuRatingBinding.menu = menuBodies?.get(position);
//
//        var circularProgressDrawable = CircularProgressDrawable(holder.itemView.getContext());
//        circularProgressDrawable.strokeWidth = 5f;
//        circularProgressDrawable.centerRadius = 30f;
//        circularProgressDrawable.start();
//
//        Glide.with(holder.itemView.getContext())
//            .load(menuBodies?.get(position)?.menu_pic_url)
//            .centerCrop()
//            .placeholder(circularProgressDrawable)
//            .into(holder.itemMenuRatingBinding.imageView);
//        holder.itemMenuRatingBinding.root.setOnClickListener {
//            menuBodies?.get(position)?.let {
//                clickMenu(
//                    it, position
//                )
//            }
//        }
//
//        holder.itemMenuRatingBinding.imageView.setOnClickListener {
//            menuBodies?.let { it1 -> clickMenu(it1.get(position), position) }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        var count = 0;
//        if (menuBodies != null)
//            count = menuBodies!!.size
//
//        return count
//    }
//}