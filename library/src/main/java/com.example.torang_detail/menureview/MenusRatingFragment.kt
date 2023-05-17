package com.example.torang_detail.menureview

//@AndroidEntryPoint
//class MenusRatingFragment : Fragment() {
//    private val mViewModel: MenuReviewViewModel by viewModels()
//    lateinit var mBinding: MenuReviewFragmentBinding
//    private val mAdapter = object : MenuRatingRvAdt() {
//        public override fun clickMenu(menuBody: Menu, position: Int) {
//            //MenuReviewsFragment.go(getChildFragmentManager(), R.id.menu_review_container);
//            mViewModel.setCurrentMenu(menuBody)
//            //MenuReviewsViewModel.obtain(activity as AppCompatActivity?).setPosition(position)
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        mBinding = MenuReviewFragmentBinding.inflate(layoutInflater, container, false)
//        mBinding.rvMenu.adapter = mAdapter
//        subscribeUi()
//
//        val restaurantId = activity?.intent?.getIntExtra("restaurantId", -1)
//        if (restaurantId != null && restaurantId != -1) {
//            mViewModel.loadMenu(restaurantId)
//        }
//        return mBinding.root
//    }
//
//    private fun subscribeUi() {
//        mViewModel.menuBodies.observe(viewLifecycleOwner, { mAdapter.setMenuBodies(it) })
//    }
//}