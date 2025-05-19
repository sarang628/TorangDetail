package com.sarang.torang

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.sarang.torang.compose.restaurant.detail.RestaurantInfo_
import com.sarang.torang.di.image.provideTorangAsyncImage
import com.sryang.library.compose.workflow.BestPracticeViewModel
import com.sryang.library.compose.workflow.PermissonWorkFlow.CheckAlreadyGranted
import com.sryang.library.compose.workflow.PermissonWorkFlow.DeniedPermission
import com.sryang.library.compose.workflow.PermissonWorkFlow.GrantedPermission
import com.sryang.library.compose.workflow.PermissonWorkFlow.Idle
import com.sryang.library.compose.workflow.PermissonWorkFlow.RecognizeToUser
import com.sryang.library.compose.workflow.PermissonWorkFlow.RequestPermission
import com.sryang.library.compose.workflow.PermissonWorkFlow.ShowRationale
import com.sryang.library.compose.workflow.PermissonWorkFlow.SuggestSystemSetting
import com.sryang.library.compose.workflow.PermissonWorkFlow.UserDeinedFromRecognize


@OptIn(ExperimentalPermissionsApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RestaurantInfoWithPermission(
    viewModel: BestPracticeViewModel,
    permission : String = android.Manifest.permission.ACCESS_FINE_LOCATION
){
    val requestPermission = rememberPermissionState(permission, { viewModel.permissionResult(it) })
    val state = viewModel.state
    var stateTxt by remember { mutableStateOf("RequestPermission") }

    when (state) {
        Idle                    /* 1. 최초 */ -> { viewModel.checkGranted(requestPermission.status.isGranted) }
        RecognizeToUser         /* 2. UX에 권한을 필요로 하는 정보 인지 시키기 */-> {
            AlertDialog(onDismissRequest = {viewModel.no()}, dismissButton = { TextButton({viewModel.no()}) { Text("No") } }, confirmButton = { TextButton({viewModel.yes()}){ Text("Yes")} }, text = {
                Text("음식점과 내 위치 거리 계신을 위해 위치 정보에 접근이 필요 합니다.")
            })
        }
        UserDeinedFromRecognize /* 3. 다이얼로그에서 사용자 거절 */ -> {  }
        CheckAlreadyGranted     /* 4. 권한 요청 전 권한 이미 있는지 확인 */-> { viewModel.alreadyGranted(requestPermission.status) }
        DeniedPermission        /* 5. 권한 거부 */-> {  }
        GrantedPermission       /* 6. 사용자가 권한을 허가했다면, 자원 접근 가능 */-> {  }
        RequestPermission       /* 7. 런타임 권한 요청하기 */ -> { LaunchedEffect(state == RequestPermission) { requestPermission.launchPermissionRequest() } }
        SuggestSystemSetting    /* 8. 권한 거부 상태에서 요청 시 */ -> {  }
        ShowRationale           /* 9. rationale을 표시 */ -> { AlertDialog(onDismissRequest = {viewModel.no()}, dismissButton = { TextButton({viewModel.no()}) { Text("No") } }, confirmButton = { TextButton({viewModel.yesRational()}){ Text("Yes")} }, text = {
            Text("음식점과 내 위치 거리 계신을 위해 위치 정보에 접근이 필요 합니다. 2회 거부 시 시스템 설정에서만 권한 부여가 가능합니다.")
        }) }
    }

    // 권한 요청시 호출
    // viewModel.request(requestPermission.status.shouldShowRationale)

    Box{
        RestaurantInfo_(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            restaurantId = 234,
            imageLoader = provideTorangAsyncImage(),
            isLocationPermissionGranted = requestPermission.status.isGranted,
            onRequestPermission = { viewModel.request(requestPermission.status.shouldShowRationale) }
        )
        Text(state.toString().split("$")[1].split("@")[0])
    }
}
