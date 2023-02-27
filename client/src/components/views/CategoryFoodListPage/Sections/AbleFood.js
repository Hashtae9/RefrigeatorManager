import React from 'react'
import { View, Dimensions } from "react-native"
import Carousel, { Pagination } from 'react-native-snap-carousel'
import { useNavigation } from '@react-navigation/native';
import AbleFoodData from './AbleFoodData'
import CarouselCardItem from '../../Common/CarouselCardItem'

const AbleFood = () => {
  const navigation = useNavigation();
  const [index, setIndex] = React.useState(0)
  const isCarousel = React.useRef(null)
  const SLIDER_WIDTH = Dimensions.get('window').width
  const ITEM_WIDTH = Math.round(SLIDER_WIDTH * 0.5)
  return (
    <View>
      <Carousel
        layout="default"
        ref={isCarousel}
        data={AbleFoodData}
        renderItem = {({item}) => {
          return <CarouselCardItem item={item} navigation={navigation}/>
        }}
        sliderWidth={SLIDER_WIDTH}
        itemWidth={ITEM_WIDTH}
        onSnapToItem={(index) => setIndex(index)}
        useScrollView={true}
      />
      <Pagination
        dotsLength={AbleFoodData.length}
        activeDotIndex={index}
        carouselRef={isCarousel}
        dotStyle={{
          width: 10,
          height: 10,
          borderRadius: 5,
          backgroundColor: 'rgba(0, 0, 0, 0.92)'
        }}
        inactiveDotOpacity={0.4}
        inactiveDotScale={0.6}
        tappableDots={true}
      />
    </View>
  )
}


export default AbleFood