package com.example.torang_detail

//AndroidEntryPoint@AndroidEntryPoint
//class RestaurantDetailFragment : Fragment() {
//
//    private lateinit var navController: NavController
//    private lateinit var appBarConfiguration: AppBarConfiguration
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val binding = FragmentRestaurantDetailBinding.inflate(layoutInflater, container, false)
//
//        val navHostFragment = childFragmentManager.findFragmentById(R.id.fc) as NavHostFragment
//        navController = navHostFragment.navController
//
//        binding.bn.setupWithNavController(navController)
//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.nav_info,
//                R.id.nav_picture,
//                R.id.nav_review,
//                R.id.nav_menurating,
//                R.id.nav_myreview
//            )
//        )
//        NavigationUI.setupWithNavController(binding.tb, navController, appBarConfiguration)
//
//        return binding.root
//    }
//
//    fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp(appBarConfiguration)
//    }
//}