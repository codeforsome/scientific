webpackJsonp([1],{"1LyN":function(t,a,s){"use strict";Object.defineProperty(a,"__esModule",{value:!0});var i=s("2CGT"),e=s("UTk+"),n=s("XI+O"),r={components:{ThesisItem:e.a,ChildItem:n.a},data:function(){return{hotUser:[],thesisList:[],itemList:[],thesisPagination:{total:100,pageSize:5,currentPage:0},itemPagination:{total:100,pageSize:5,currentPage:0}}},methods:{thesisCurrentChange:function(t){var a=this;this.thesisPagination.currentPage=t;var s={currentPage:t,pageSize:this.thesisPagination.pageSize};Object(i.i)(s).then(function(t){var s=t.data;a.thesisList=s.data},function(t){})},itemCurrentChange:function(t){var a=this;this.itemPagination.currentPage=t;var s={currentPage:t,pageSize:this.itemPagination.pageSize};Object(i.g)(s).then(function(t){var s=t.data;a.itemList=s.data},function(t){})}},created:function(){var t=this;Object(i.n)().then(function(a){var s=a.data;t.hotUser=s.data},function(t){}),Object(i.i)("").then(function(a){var s=a.data;t.thesisList=s.data},function(t){}),Object(i.g)().then(function(a){var s=a.data;t.itemList=s.data},function(t){}),Object(i.m)().then(function(a){var s=a.data;t.thesisPagination.total=s.data},function(t){})}},c={render:function(){var t=this,a=t.$createElement,i=t._self._c||a;return i("div",{staticClass:"main"},[i("div",{staticClass:"block"},[i("el-carousel",{attrs:{interval:8e3}},t._l(4,function(t){return i("el-carousel-item",{key:t},[i("router-link",{attrs:{to:{name:"Main"}}},[i("img",{staticClass:"slide-img",attrs:{src:s("FsUD"),alt:""}})])],1)}),1)],1),t._v(" "),i("div",{staticClass:"main-wrap"},[i("div",{staticClass:"main-show"},[i("el-card",{staticClass:"box-card"},[i("div",{staticClass:"head"},[i("span",{staticClass:"head-title"},[t._v("热门老师")])]),t._v(" "),i("div",{staticClass:"user-list"},t._l(t.hotUser,function(a,s){return i("div",{key:s,staticClass:"item"},[i("div",{staticClass:"left"},[i("img",{staticClass:"head-icon",attrs:{src:a.headIcon}})]),t._v(" "),i("div",{staticClass:"right"},[i("div",{staticClass:"top"},[i("span",{staticClass:"hot"},[t._v("热门")]),t._v(" "),i("span",{staticClass:"name"},[t._v(t._s(a.nickname))])]),t._v(" "),i("div",{staticClass:"center"},[i("p",{staticClass:"college"},[t._v("学院："+t._s(a.college))])]),t._v(" "),i("div",{staticClass:"bottom"},[i("span",{staticClass:"thesisNum num",attrs:{title:"论文量"}},[i("span",{staticClass:"el-icon-reading"}),t._v("\n                  "+t._s(a.thesisNum)+"\n                ")]),t._v(" "),i("span",{staticClass:"readNum num",attrs:{title:"热度量"}},[i("span",{staticClass:"el-icon-s-promotion"}),t._v("\n                  "+t._s(a.hot)+"\n                ")])]),t._v(" "),i("div",{staticClass:"button-wrap"},[i("el-button",{staticClass:"button",attrs:{type:"primary",round:""}},[i("router-link",{staticClass:"link",attrs:{to:{name:"UserInfo",params:{id:a.id}}}},[t._v("查看更多")]),t._v(" "),i("span",{staticClass:"el-icon-d-arrow-right"})],1)],1)])])}),0)])],1),t._v(" "),i("div",{staticClass:"mian-thesis-hot"},[i("el-card",{staticClass:"box-card"},[i("div",{staticClass:"hot-title"},[t._v("热门论文")]),t._v(" "),i("div",{staticClass:"thesis-list"},[t._l(t.thesisList,function(t,a){return[i("thesis-item",{key:a,attrs:{thesis:t}})]}),t._v(" "),i("div",{staticClass:"bottom-box"},[i("el-pagination",{attrs:{background:"",layout:"prev, pager, next",total:t.thesisPagination.total,"page-size":t.thesisPagination.pageSize},on:{"current-change":t.thesisCurrentChange,"prev-click":t.thesisCurrentChange,"next-click":t.thesisCurrentChange}})],1)],2)]),t._v(" "),i("el-card",{staticClass:"box-card item-box"},[i("div",{staticClass:"hot-title"},[t._v("最新科研题目")]),t._v(" "),i("div",{staticClass:"thesis-list"},[t._l(t.itemList,function(t,a){return[i("child-item",{key:a,attrs:{item:t}})]}),t._v(" "),i("div",{staticClass:"bottom-box"},[i("el-pagination",{attrs:{background:"",layout:"prev, pager, next",total:t.itemPagination.total,"page-size":t.itemPagination.pageSize},on:{"current-change":t.itemCurrentChange,"prev-click":t.itemCurrentChange,"next-click":t.itemCurrentChange}})],1)],2)])],1)])])},staticRenderFns:[]};var o=s("VU/8")(r,c,!1,function(t){s("Mj2N")},"data-v-6f70931d",null);a.default=o.exports},FsUD:function(t,a,s){t.exports=s.p+"static/img/slider-2-1.cefa9c3.png"},Mj2N:function(t,a){},OT8v:function(t,a){},"XI+O":function(t,a,s){"use strict";var i={props:{item:{type:Object,required:!0},show:{type:Boolean,default:!1}}},e={render:function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{staticClass:"item"},[s("div",{staticClass:"left"},[s("span",{staticClass:"day"},[t._v(t._s(t.item.createDate.slice(5,10)))]),t._v(" "),s("span",{staticClass:"year"},[t._v(t._s(t.item.createDate.slice(0,4)))])]),t._v(" "),s("div",{staticClass:"right"},[s("div",{staticClass:"title"},[s("span",[s("router-link",{attrs:{to:{name:"ItemShow",params:{id:t.item.id}}}},[t._v(t._s(t.item.title))])],1),t._v(" "),s("router-link",{directives:[{name:"show",rawName:"v-show",value:t.show,expression:"show"}],staticStyle:{"margin-left":"6px"},attrs:{to:{name:"itemUpdate",params:{id:t.item.id}}}},[s("el-link",{attrs:{icon:"el-icon-edit"}},[t._v("编辑")])],1)],1),t._v(" "),s("div",{staticClass:"abstract"},[t._v("科研要求"+t._s(t.item.content.slice(0,50)+"..."))]),t._v(" "),s("el-divider")],1)])},staticRenderFns:[]};var n=s("VU/8")(i,e,!1,function(t){s("OT8v")},"data-v-ffacd72a",null);a.a=n.exports}});
//# sourceMappingURL=1.131d523a4adf487c311a.js.map