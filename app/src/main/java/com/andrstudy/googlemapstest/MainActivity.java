package com.andrstudy.googlemapstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener{

    // 구글 맵 참조변수 생성
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // 구글맵 호출
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // 구글 맵 객체를 불러온다.dd;
        //
        map = googleMap;

        // 서울 여의도에 대한 위치 설정
        LatLng seoul = new LatLng(37.52487, 126.92723);

        // 구글 맵에 표시할 마커에 대한 옵션 설정
        MarkerOptions makerOptions = new MarkerOptions();
        makerOptions
                .position(seoul)
                .title("원하는 위치(위도, 경도)에 마커를 표시했습니다.")
                .snippet("추가 텍스트")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));// 아이콘 바꾸기

        // 마커를 생성한다.
        map.addMarker(makerOptions);

        //카메라를 여의도 위치로 옮긴다.
        map.moveCamera(CameraUpdateFactory.newLatLng(seoul));

        // 마커클릭리스너
        map.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Toast.makeText(this,marker.getTitle() + "\n" + marker.getPosition(), Toast.LENGTH_SHORT).show();
        // return을 false로 지정하면 Toast와 marker내용이 같이뜨고 true면 Toast만뜬다
        return true;
    }
}
