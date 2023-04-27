<template>
  <div class="cardContent">
    <div class="cardBox">
      <div
        :class="['card-item', `card-item-${index + 1}`]"
        v-for="(item, index) in drawList"
        :key="index"
      >
        <!-- 数组中存入index值时，将写有动画的class属性赋给标签，即开始播放动画 -->
        <div
          :class="['card', selectArr.includes(index) ? 'cardAnimate' : '']"
        >卡牌背面</div>
        <div
          :class="['contxt', selectArr.includes(index) ? 'contxtAnimate' : '']"
        >卡牌{{index+1}}正面
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "AddMerit",
  data() {
    return {
      drawList:5,
      selectArr: [],
    };
  },
  mounted() {
    //数组中存入index值时，将写有动画的class属性赋给标签，即开始播放动画
    //自动播放翻牌动画，1500ms后播放第一张翻牌动画，然后每200ms播放一张
    for (let i = 0; i < 6; i++) {
      setTimeout(() => {
        this.selectArr.push(i);
      }, 1500 + (i - 1) * 200);
    }
  },
};
</script>

<style>
 
/* 每张卡牌属性 */
.card-item {
  width: 212rpx;
  height: 252rpx;
  margin: 10rpx;
  border-radius: 10px;
/* 文字居中 */
  line-height:252rpx;
  text-align: center;
}
/* 翻转前 */
.card-item .card {
  width: 212rpx;
  height: 252rpx;
  border-radius: 10px;
  backface-visibility: hidden;
  background-color: aliceblue; 
}
/* 翻转后 */
.card-item .contxt {
  width: 212rpx;
  height: 252rpx;
  border-radius: 10px;
  backface-visibility: hidden;
  /* 定位于和翻转前相同的位置 */
  position: relative;
  top: -252rpx;
  left: 0;
/* Y轴翻转180°，成卡牌效果*/
  transform: rotateY(180deg);
  opacity: 0;
  background-color: bisque;
}
/*将每个卡牌进行定位*/
.card-item-1 {
  position: absolute;
  left: 20rpx;
  top: 200rpx;
  animation: issueCard1 1.5s;
}
.card-item-2 {
  position: absolute;
  left: 252rpx;
  top: 200rpx;
  animation: issueCard2 1.5s;
}
.card-item-3 {
  position: absolute;
  left: 484rpx;
  top: 200rpx;
  animation: issueCard3 1.5s;
}
.card-item-4 {
  position: absolute;
  left: 136rpx;
  top: 472rpx;
  animation: issueCard4 1.5s;
}
.card-item-5 {
  position: absolute;
  left: 368rpx;
  top: 472rpx;
  animation: issueCard5 1.5s;
}
/* 卡片翻牌 */
/* 背面 */
.cardAnimate {
  animation: rotetaCard 0.5s ease-in;
  animation-fill-mode: forwards;
}
/* 正面 */
.contxtAnimate {
  animation: contxtRotate 0.5s ease-in;
  animation-fill-mode: forwards;
}
/* 正面卡牌翻牌动画 */
@keyframes contxtRotate {
  from {
    transform: rotateY(180deg);
    opacity: 1;
  }
 
  to {
    transform: rotateY(0deg);
    opacity: 1;
  }
}
 
/* 背面卡牌翻牌动画 */
@keyframes rotetaCard {
  from {
    transform: rotateY(0);
  }
 
  to {
    transform: rotateY(180deg);
  }
}
 
/* 每张卡牌发牌动画 */
@keyframes issueCard1 {
  0% {
    position: fixed;
    top: 750rpx;
    left: 269rpx;
    transform: scale(0);
  }
  20% {
    transform: scale(1.2);
  }
  40% {
    transform: scale(1);
  }
  50% {
    position: fixed;
    top: 750rpx;
    left: 269rpx;
    transform: scale(1);
  }
  60% {
    position: fixed;
    left: 20rpx;
    top: 200rpx;
  }
  100% {
  }
}
@keyframes issueCard2 {
  0% {
    position: fixed;
    top: 750rpx;
    left: 269rpx;
    transform: scale(0);
  }
  20% {
    transform: scale(1.2);
  }
  40% {
    transform: scale(1);
  }
  50% {
    position: fixed;
    top: 750rpx;
    left: 269rpx;
    transform: scale(1);
  }
  60% {
    position: fixed;
    top: 750rpx;
    left: 269rpx;
    transform: scale(1);
  }
  70% {
    position: absolute;
    left: 252rpx;
    top: 200rpx;
  }
  100% {
  }
}
@keyframes issueCard3 {
  0% {
    position: fixed;
    top: 750rpx;
    left: 269rpx;
    transform: scale(0);
  }
  20% {
    transform: scale(1.2);
  }
  40% {
    transform: scale(1);
  }
  50% {
    position: fixed;
    top: 750rpx;
    left: 269rpx;
    transform: scale(1);
  }
  70% {
    position: fixed;
    top: 750rpx;
    left: 269rpx;
    transform: scale(1);
  }
  80% {
    position: absolute;
    left: 484rpx;
    top: 200rpx;
  }
  100% {
  }
}
@keyframes issueCard4 {
  0% {
    position: fixed;
    top: 750rpx;
    left: 269rpx;
    transform: scale(0);
  }
  20% {
    transform: scale(1.2);
  }
  40% {
    transform: scale(1);
  }
  50% {
    position: fixed;
    top: 750rpx;
    left: 269rpx;
    transform: scale(1);
  }
  80% {
    position: fixed;
    top: 750rpx;
    left: 269rpx;
    transform: scale(1);
  }
  90% {
    position: absolute;
    left: 136rpx;
    top: 472rpx;
  }
  100% {
  }
}
@keyframes issueCard5 {
  0% {
    position: fixed;
    top: 750rpx;
    left: 269rpx;
    transform: scale(0);
  }
  20% {
    transform: scale(1.2);
  }
  40% {
    transform: scale(1);
  }
  50% {
    position: fixed;
    top: 750rpx;
    left: 269rpx;
    transform: scale(1);
  }
  90% {
    position: fixed;
    top: 750rpx;
    left: 269rpx;
    transform: scale(1);
  }
  100% {
    position: absolute;
    left: 368rpx;
    top: 472rpx;
  }
}
</style>

<!-- <template>
  <h3>AddMerit</h3>

</template>

<script>
export default {
  name: "AddMerit",
  data() {
    return {}
  },
  created() {

  },
  methods: {},
}
</script> -->