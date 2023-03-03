import * as React from 'react';
import { useState } from 'react';
import { useNavigation } from '@react-navigation/native';
import { useCameraDevices } from 'react-native-vision-camera';
import { Camera } from 'react-native-vision-camera';
import { useScanBarcodes, BarcodeFormat } from 'vision-camera-code-scanner';
import { View, Text, ScrollView, StyleSheet, TouchableOpacity, Image, Button, Dimensions, TextInput } from 'react-native'
import { Overlay } from '@rneui/themed';
import axios from 'axios';
import { useSelector } from 'react-redux';

export default function BarcodeScanner() {
  const user = useSelector(state => state.user.loginSuccess);
  const refri = user.refrigerator

  const [hasPermission, setHasPermission] = React.useState(false);
  const devices = useCameraDevices();
  const device = devices.back;
  const navigation = useNavigation();
  const [frameProcessor, barcodes] = useScanBarcodes([BarcodeFormat.ALL_FORMATS], {
    checkInverted: true,
  });
  const barcodeHandler = (barcode) => {
    const getURl = 'http://10.0.2.2:8080/ingredient/api/bacode/' + barcode;
    axios.get(getURl)
     .then(response => {
      setfoodName(response.data)
      setDateVisible(true)
    })
     .catch(error => console.log(error))
  }
  // const registerBarcode = (barcode) => {
  //   axios.post('http://10.0.2.2:8080/ingre_refri/api/addIngre', body)
  //    .then(response => response.data)
  //    .catch(error => console.log(error))
  // }
  // Alternatively you can use the underlying function:
  //
  // const frameProcessor = useFrameProcessor((frame) => {
  //   'worklet';
  //   const detectedBarcodes = scanBarcodes(frame, [BarcodeFormat.QR_CODE], { checkInverted: true });
  //   runOnJS(setBarcodes)(detectedBarcodes);
  // }, []);
  const [dateVisible, setDateVisible] = useState(false)
  const [foodName, setfoodName] = useState("")
  const [expireDate, setExpireDate] = useState("")
  const willAddIngredientHandler = () => {
    body = {
        "refriInfo" : {
            "refriID" : refri
        } ,
        "ingreInfo" : {
          "ingreName" : foodName,
          "imgSource" : "",
          "defaultIngre": "",
        },
        "IngreRefriInfo" : {
            "refriExpirDate" :expireDate,
            "frozen" : 1,
            "ingreSeq" : 500,
            "refriID" : refri
        }
    }
    setDateVisible(false)
    setfoodName("")
    setExpireDate("")
    console.log(body)
    axios.post('http://10.0.2.2:8080/ingre_refri/api/addIngre', body)
     .then(response => navigation.navigate("RefrigeratorPage"))
     .catch(error => console.log(error))

  }
  React.useEffect(() => {
    (async () => {
      const status = await Camera.requestCameraPermission();
      setHasPermission(status === 'authorized');
    })();
  }, []);

  return (
    device != null &&
    hasPermission && (
      <>
        <Camera
          style={StyleSheet.absoluteFill}
          device={device}
          isActive={true}
          frameProcessor={frameProcessor}
          frameProcessorFps={5}
          
        />
        <View>
            <Overlay isVisible={dateVisible} onBackdropPress={() => setDateVisible(false)}>
              <Text style={styles.textPrimary}>유통 기한을 입력하세요.</Text>
              <TextInput
                value={expireDate}
                onChangeText={(expireDate) => setExpireDate(expireDate)}
                placeholder={"YYYY-MM-DD"}
                style={styles.input}    
              />
              <Button
                title="확인"
                color="pink"
                onPress={ () => willAddIngredientHandler()}
              />
            </Overlay>
          </View>
        {barcodes.map((barcode, idx) => (
          barcodeHandler(barcode.displayValue)
        ))}
      </>
    )
  );
}

const styles = StyleSheet.create({
  barcodeTextURL: {
    fontSize: 20,
    color: 'white',
    fontWeight: 'bold',
  },
});