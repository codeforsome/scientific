webpackJsonp([10],{OgLj:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var s=i("2CGT"),a={data:function(){return{inputValue:"",title:"",content:"",disciplineSpecialtyList:[{value:"互联网",label:"互联网"},{value:"金融",label:"金融"},{value:"文学",label:"文学"},{value:"创新",label:"创新"},{value:"工业技术",label:"工业技术"},{value:"电子工程与计算机",label:"电子工程与计算机"}],disciplineSpecialty:"",tip:"",success:!1}},methods:{back:function(){this.$router.go(-1)},successFile:function(){this.success=!0},checkInput:function(){return""===this.title?(this.$refs.title.focus(),!1):""!==this.content||(this.$refs.content.focus(),!1)},submit:function(){var t=this;if(this.checkInput()){var e={};e.disciplineSpecialty=this.disciplineSpecialty,e.content=this.content,e.title=this.title,Object(s.s)(e).then(function(e){var i=e.data;t.tip=i.msg,i.success&&setTimeout(function(){t.$router.push({name:"My"})},1e3)},function(t){})}}},created:function(){var t=this;Object(s.f)(this.id).then(function(e){var i=e.data.data;t.title=i.title,t.content=i.content,t.disciplineSpecialty=i.disciplineSpecialty},function(t){})}},n={render:function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"thesis-add"},[i("div",{staticClass:"thesis"},[i("div",{staticClass:"row"},[i("span",{staticClass:"name"},[t._v("科研题目：")]),t._v(" "),i("div",{staticClass:"input-wrap"},[i("el-input",{ref:"title",attrs:{placeholder:"请输入科研题目",maxlength:"20",autofocus:"",clearable:""},model:{value:t.title,callback:function(e){t.title=e},expression:"title"}})],1)]),t._v(" "),i("div",{staticClass:"row"},[i("span",{staticClass:"name"},[t._v("科研要求：")]),t._v(" "),i("div",{staticClass:"input-wrap"},[i("el-input",{ref:"content",attrs:{type:"textarea",autosize:{minRows:4,maxRows:10},maxlength:"1000",placeholder:"请输入科研要求"},model:{value:t.content,callback:function(e){t.content=e},expression:"content"}})],1)]),t._v(" "),i("div",{staticClass:"row"},[i("span",{staticClass:"name"},[t._v("学科专业：")]),t._v(" "),i("div",{staticClass:"change-wrap"},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.disciplineSpecialty,callback:function(e){t.disciplineSpecialty=e},expression:"disciplineSpecialty"}},t._l(t.disciplineSpecialtyList,function(t){return i("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})}),1)],1)]),t._v(" "),i("div",{staticClass:"row"},[i("el-button",{staticClass:"register",attrs:{round:""},on:{click:function(e){return t.back()}}},[t._v("返回上一级")]),t._v(" "),i("el-button",{staticClass:"register",attrs:{round:""},on:{click:function(e){return t.submit()}}},[t._v("提交信息")])],1),t._v(" "),i("div",{staticClass:"tip-error-wrap"},[i("span",{staticClass:"tip-error"},[t._v(t._s(t.tip))])])])])},staticRenderFns:[]};var l=i("VU/8")(a,n,!1,function(t){i("dng7")},"data-v-e2f1238e",null);e.default=l.exports},dng7:function(t,e){}});
//# sourceMappingURL=10.f19010e8ef3389a12460.js.map