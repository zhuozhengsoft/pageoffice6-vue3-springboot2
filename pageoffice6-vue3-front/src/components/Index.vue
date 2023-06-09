<script setup>
defineProps({
  msg: {
    type: String,
    required: true
  }
})
</script>
<template>
  <div class="greetings">
    <br />
    <h1>
      PageOffice<span style="font-size: 24px; vertical-align: text-top;">®</span>
    </h1>
    <div class="slogan">
      <div>政府企事业单位在线Office(Word/Excel/PDF/PPT/WPS)编辑中间件（控件）</div>
      <div>服务器端操作系统不限，客户端支持Windows、国产操作系统</div>
    </div>
    <br />
    <div class="note">
      “通用控制”的代码功能演示属于Word、Excel、PPT通用的功能。所以虽然下面的示例打开的都是Word文档，但实际上打开Excel和PPT也是可以实现完全相同功能的。
    </div>
    <div>
      <h2 id="通用控制">通用控制</h2>
      <table>
        <thead>
          <tr>
            <th style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/SimpleWord' , 'width=1200px;height=800px;')" >最简单的打开保存文件</a></th>
            <th style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/OpenDisk' , 'width=1200px;height=800px;')">磁盘路径打开文档</a></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/TitleText' , 'width=1200px;height=800px;')">修改标题栏文本</a></td>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/CustomToolButton1' , 'width=1200px;height=800px;')">自定义工具条上添加按钮</a></td>
          </tr>
          <tr>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/HideOfficeToolbar' , 'width=1200px;height=800px;')">隐藏Office工具栏</a></td>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/HideCustomToolbar' , 'width=1200px;height=800px;')">隐藏自定义工具栏</a></td>
          </tr>
          <tr>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/SaveReturnValue' , 'width=1200px;height=800px;')">保存后给前台返回自定义结果</a></td>
             <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/SaveDataAndFile' , 'width=1200px;height=800px;')">保存数据区域数据同时保存文档</a></td>
          </tr>
          <tr>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/SendParameters' , 'width=1200px;height=800px;')">给SaveFilePage指向的地址传参</a></td>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/SendParameters2' , 'width=1200px;height=800px;')">SaveFilePage获取页面Form域</a></td>
          </tr>
          <tr>
            <td style="text-align: left;"><router-link to="basic/CallParentFunction/index" target="_blank">POBrowser回调父页面的函数传值</router-link></td>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/GetParentParamValue' , 'width=1200px;height=800px;','123')">给POBrowser打开的页面传参</a></td>
          </tr>
          <tr>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/SaveAsHTML' , 'width=1200px;height=800px;')">另存文件为HTML格式</a></td>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/SaveAsPDF' , 'width=1200px;height=800px;')">另存文件为PDF格式</a></td>
          </tr>
          <tr>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/AfterDocOpened' , 'width=1200px;height=800px;')">文档打开后触发的事件</a></td>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/BeforeSave' , 'width=1200px;height=800px;')">文档保存前触发的事件</a></td>
          </tr>
          <tr>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/AfterSave' , 'width=1200px;height=800px;')">文档保存后触发的事件</a></td>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/DataBase' , 'width=1200px;height=800px;')">打开保存数据库中的文件</a></td>
          </tr>  
            <tr>
               <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/CreateWord' , 'width=1200px;height=800px;')">WebCreateNew新建文件</a></td>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/POBrowserPosition' , 'width=1200px;height=800px;')">控制POBrowser窗口的位置</a></td>
          </tr>
          <tr>
            <td style="text-align: left;"><a href="javascript:POBrowser.openWindow('basic/NoBlank' , 'width=1200px;height=800px;')">PageOffice控件铺满整个页面</a></td>
          </tr>
           <tr> 
             <td style="text-align: left;">           
            </td>
             <td style="text-align: left;">           
            </td>
           </tr>    
        </tbody>
      </table>
      <h2 id="word">
        Word
      </h2>
      <h4 id="常规">
      常用控制
      </h4>
      <table>
        <thead>
          <tr>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/RevisionOnly' , 'width=1200px;height=800px;')" class="">强制留痕模式打开文件</a>
            </th>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/RevisionsList' , 'width=1200px;height=800px;')" class="">显示痕迹列表</a>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/ReadOnly' , 'width=1200px;height=800px;')" class="">只读打开文档</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/ReadOnly2' , 'width=1200px;height=800px;')"  class="">文件在线安全浏览</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
              <a href="/word/normal/InsertSeal/Index" class="">加盖印章和签字功能</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/WordCompare' , 'width=1200px;height=800px;')"  class="">比较两个版本的Word文档</a>
            </td>
          </tr>
            <tr>        
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/DisableCopyOut' , 'width=1200px;height=800px;')" class="">编辑时禁止拷贝到外部</a>
            </td>
             <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/WordDisableRight' , 'width=1200px;height=800px;')" class="">禁止Word中鼠标右键</a>
            </td>
          </tr>         
          <tr>
            <td style="text-align: left;">
              <a href="word/normal/SameTimeEdit/Index"  class="">多用户同时编辑</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/WordResWord' , 'width=1200px;height=800px;')"  class="">word多文档合并</a>
            </td>
          </tr>
          <!-- <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/DataRegionEdit' , 'width=1200px;height=800px;')" class=""><font color="red">用户自定义模板中数据区域</font></a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/DataTagEdit' , 'width=1200px;height=800px;')" class=""><font color="red">用户自定义模板中数据标签</font></a>
            </td>
          </tr> -->
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/DataRegionReadOnly' , 'width=1200px;height=800px;')" class="">控制编辑区域(局部编辑)</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/AddWaterMark' , 'width=1200px;height=800px;')" class="">添加水印</a> |
              <a href="javascript:POBrowser.openWindow('word/normal/AddWaterMark2' , 'width=1300px;height=900px;');" class="" data-v-c9226b74=""> 图片水印</a>
              
            </td>
          </tr>
           <tr>           
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/InsertPageBreak2' , 'width=1200px;height=800px;')"  class="">插入分页符</a>
            </td>
              <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/CreateBlankFile' , 'width=1200px;height=800px;')" class="">创建空白的word、excel、ppt</a>
            </td>
             <!-- <td style="text-align: left;">
              <a href="word/normal/TaoHong" class=""><font color="red">模板套红</font></a>
            </td> -->
          </tr>
           <tr>           
            <!-- <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/normal/CreateWordFromTemplate' , 'width=1200px;height=800px;')"  class=""><font color="red">从模板起草文件</font></a>
            </td> -->
           
          </tr> 
          <tr> 
             <td style="text-align: left;">           
            </td>
             <td style="text-align: left;">           
            </td>
           </tr>    
        </tbody>
      </table>
      <h4 id="数据填充">
        动态填充
      </h4>
      <table>
        <thead>
          <tr>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/DataRegionFill' , 'width=1200px;height=800px;')"  class="">数据区域填充文本</a>
            </th>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/WordResImage' , 'width=1200px;height=800px;')"  class="">数据区域插入图片</a>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/DataRegionStyle' , 'width=1200px;height=800px;')"  class="">设置数据区域文本样式</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/WordCreateTable' , 'width=1200px;height=800px;')"  class="">数据区域生成表格</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
               <a href="javascript:POBrowser.openWindow('word/normal/WordResWord' , 'width=1200px;height=800px;')"  class="">数据区域插入Word文档</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/WordResExcel' , 'width=1200px;height=800px;')" class="">数据区域插入Excel</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/WordDataTag' , 'width=1200px;height=800px;')" class="">数据标签填充文本</a>
            </td>
             <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/WordDataTag2' , 'width=1200px;height=800px;')" class="">设置数据标签文本样式</a>
            </td>
          </tr>
          <tr>           
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/DataRegionFill2' , 'width=1200px;height=800px;')" class="">给数据区域赋值并设置样式</a>
            </td>
              <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/WordTextBox' , 'width=1200px;height=800px;')"  class="">给文本框中的数据区域赋值</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/TableInsertRow' , 'width=1200px;height=800px;')" class="">文档中的Table插入新行并赋值</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/MergeWordCell' , 'width=1200px;height=800px;')" class="">合并Word中表格的单元格</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/WordTableSetImg' , 'width=1200px;height=800px;')" class="">单元格内插入图片</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/WordTableBorder' , 'width=1200px;height=800px;')" class="">设置Word表格的样式</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/WordSetTable' , 'width=1200px;height=800px;')" class="">Word表格赋值</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/WordDeleteRow' , 'width=1200px;height=800px;')" class="">删除表格中的指定单元格所在行</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/DataRegionCreate' , 'width=1200px;height=800px;')" class="">动态创建数据区域</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/WordParagraph' , 'width=1200px;height=800px;')" class="">动态生成Word文件</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/insert/InsertImageSetSize' , 'width=1200px;height=800px;')" class="">动态插入图片并设置大小</a>
            </td>          
          </tr> 
          <tr>
            <td></td>
          </tr>                 
        </tbody>
      </table>
      <h4 id="数据提交">
        用户输入提交
      </h4>
      <table>
        <thead>
          <tr>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/extract/SubmitWord' , 'width=1200px;height=800px;')" class="">提取数据区域中文本</a>
            </th>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/extract/ExtractImage' , 'width=1200px;height=800px;')" class="">提取数据区域中图片</a>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/extract/SplitWord' , 'width=1200px;height=800px;')" class="">提取数据区域为子文件(Word拆分)</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/extract/SubmitTable' , 'width=1200px;height=800px;')" class="">提取表格数据</a>
            </td>
          </tr> 
          <tr>
            <td></td><td></td>
          </tr>        
        </tbody>
      </table>
      <h4 id="JS控制">
        JS控制
      </h4>
      <table>
        <tbody>
           <tr>
             <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/js/InsertWaterMarkForJs' , 'width=1200px;height=800px;')"  class="">js插入水印</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/js/WordLocateBKMK' , 'width=1200px;height=800px;')"  class="">js定位光标到书签</a>
            </td>          
          </tr>
           <!-- <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/js/InsertPageBreak' , 'width=1200px;height=800px;')"  class="">js在当前光标处插入分页符</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/js/InsertImgForJs' , 'width=1200px;height=800px;')"  class="">js在当前光标处插入图片</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/js/WordHyperLink' , 'width=1200px;height=800px;')"  class="">js插入超文本链接</a>
            </td>
           
          </tr>
          <tr>
             <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/js/InsertPageBreak' , 'width=1200px;height=800px;')"  class="">js在当前光标处插入书签</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/js/InsertImgForJs' , 'width=1200px;height=800px;')"  class="">js删除选中文本中的书签</a>
            </td>
          </tr> -->
          <tr>       
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/js/WordGetSelection' , 'width=1200px;height=800px;')"  class="">js获取选中的文字</a>
            </td>
               <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/js/DocumentMap' , 'width=1200px;height=800px;')"  class="">js隐藏导航窗口</a>
            </td>
          </tr>
          <!-- <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/js/WordGoToPage' , 'width=1200px;height=800px;')"  class="">js跳转到指定页</a>
            </td>
          
          </tr> -->
          <tr>           
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/js/PageCount' , 'width=1200px;height=800px;')"  class="">js获取到文档总页数</a>
            </td>
              <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/js/PageNum' , 'width=1200px;height=800px;')"  class="">js获取当前是第几页</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('word/js/ZoomPercentage' , 'width=1200px;height=800px;')"  class="">js设置视图缩放比例</a>
            </td>
          </tr>
          <tr>
            <td></td>
            <td></td>
          </tr>
        </tbody>
      </table>
      <!-- <h4 id="filemaker">
        FileMaker
      </h4>
      <table>
        <thead>
          <tr>
            <th style="text-align: left;">
              <a href="/filemaker/FileMakerSingle.html" class="">仿服务器端生成Word文档</a>
            </th>
            <th style="text-align: left;">
              <a href="/filemaker/FileMakerPDF.html" class="">仿服务器端生成PDF文档</a>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style="text-align: left;">
              <a href="/filemaker/FileMakerMulti.html" class="">批量生成Word文档</a>
            </td>
            <td style="text-align: left;">
              <a href="/filemaker/FileMakerConvertPDFs.html" class="">批量转换PDF文件</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
              <a href="/filemaker/PrintFiles.html" class="">批量生成并打印文件</a>
            </td>
            <td style="text-align: left;"></td>
          </tr>
        </tbody>
      </table>      -->
      <h2 id="excel">
        Excel
      </h2>
      <h4 id="常规-2">
      常用控制
      </h4>
      <table>
        <thead>
          <tr>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/normal/SimpleExcel' , 'width=1200px;height=800px;')"  class="">编辑模式打开</a>
            </th>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/normal/ReadOnlyExcel' , 'width=1200px;height=800px;')"  class="">只读打开文档</a>
            </th>
          </tr>
          <tr>
              <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/normal/ExcelAdjustRC' , 'width=1200px;height=800px;')"  class="">只读模式下调整行列</a>
            </td>
              <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/normal/ExcelDisableRight' , 'width=1200px;height=800px;')" class="">禁止Excel中鼠标右键</a>
            </td>
          </tr>
          <tr>
            <td></td>
            <td></td>
          </tr>
        </thead>
        <tbody></tbody>
      </table>
      <h4 id="数据填充-2">
        动态填充
      </h4>
      <table>
        <thead>
          <tr>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/insert/ExcelFill' , 'width=1200px;height=800px;')"  class="">单元格填充数据</a>
            </th>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/insert/ExcelInsertImage' , 'width=1200px;height=800px;')"  class="">单元格添加图片</a>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/insert/SetExcelCellText' , 'width=1200px;height=800px;')"  class="">设置单元格的字体样式</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/insert/ExcelFill2' , 'width=1200px;height=800px;')"  class="">单元格赋值并设置文本颜色</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/insert/SetExcelCellText2' , 'width=1200px;height=800px;')"  class="">设置单元格的对齐方式和背景色</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/insert/DefinedNameCell' , 'width=1200px;height=800px;')"  class="">给定义了名称的单元格赋值</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/insert/DefinedNameTable' , 'width=1200px;height=800px;')"  class="">给定义了名称的一块区域赋值</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/insert/ExcelTable' , 'width=1200px;height=800px;')"  class="">对一块区域赋值，并自动增加行</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/insert/DrawExcel' , 'width=1200px;height=800px;')"  class="">动态生成Excel文件</a>
            </td>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/insert/ExcelBorder' , 'width=1200px;height=800px;')"  class="">设置表格线</a>
            </td>
          </tr>
           <tr>
            <td></td>
            <td></td>
          </tr>
        </tbody>
      </table>
      <h4 id="数据提交-2">
        用户输入提交
      </h4>
      <table>
        <thead>
          <tr>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('excel/extract/SubmitExcel' , 'width=1200px;height=800px;')"  class="">提取单元格数据</a>
            </th>            
          </tr>
           <tr>
            <td></td>
            <td></td>
          </tr>
        </thead>
        <tbody></tbody>
      </table>
      <!-- <h4 id="更多-2">
        更多
      </h4>
      <table>
        <tbody>
          <tr>
            <td style="text-align: left;">
              <a href="/excel/more/ExcelCellClick.html" class="">响应单元格点击事件</a>
            </td>
            <td style="text-align: left;">
              <a href="/excel/more/ExcelAdjustRC.html" class="">只读模式下调整行列</a>
            </td>
          </tr>
          <tr>
            <td style="text-align: left;">
              <a href="/excel/more/JsOpXlsCellText.html" class="">js获取和设置单元格的值</a>
            </td>
            <td style="text-align: left;">
              <a href="/excel/more/ExcelDisableRight.html" class="">禁止Excel中鼠标右键</a>
            </td>
          </tr>
        </tbody>
      </table>
      <h2 id="pdf">
        PDF
      </h2>
      <table>
        <thead>
          <tr>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('pdf/POPDF' , 'width=1200px;height=800px;')">最简单的打开PDF</a>
            </th>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('pdf/CustomToolButton2' , 'width=1200px;height=800px;')">添加自定义工具栏按钮</a>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('pdf/PDFSearch' , 'width=1200px;height=800px;')">文档中的关键字搜索</a>
            </td>
            <td style="text-align: left;"></td>
          </tr>
        </tbody>
      </table> -->
      <h2 id="ppt">
        PPT
      </h2>
      <table>
        <thead>
          <tr>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('ppt/SimplePPT' , 'width=1200px;height=800px;')">最简单的打开PPT</a>
            </th>
            <th style="text-align: left;">
              <a href="javascript:POBrowser.openWindow('ppt/ReadOnlyPPT' , 'width=1200px;height=800px;')">只读打开PPT</a>
            </th>
          </tr>
        </thead>
        <tbody></tbody>
      </table>
    </div>

    <div class="small">
      <div style="border-bottom: solid 1px #ccc;margin-bottom: 10px;">目录</div>
      <div><a href="#通用控制">通用控制</a></div>
      <div><a href="#word">Word</a></div>
      <div style="padding-left: 25px;"><a href="#常规">常用控制</a></div>
      <div style="padding-left: 25px;"><a href="#数据填充">动态填充</a></div>
      <div style="padding-left: 25px;"><a href="#数据提交">用户输入提交</a></div>
      <div style="padding-left: 25px;"><a href="#JS控制">JS控制</a></div>
      <!-- <div style="padding-left: 25px;"><a href="#filemaker">FileMaker</a></div> -->
      <div><a href="#excel">Excel</a></div>
      <div style="padding-left: 25px;"><a href="#常规-2">常用控制</a></div>
      <div style="padding-left: 25px;"><a href="#数据填充-2">动态填充</a></div>
      <div style="padding-left: 25px;"><a href="#数据提交-2">用户输入提交</a></div>
      <!-- <div style="padding-left: 25px;"><a href="#更多-2">更多</a></div> -->
      <!-- <div><a href="#pdf">PDF</a></div> -->
      <div><a href="#ppt">PPT</a></div>

    </div>

  </div>

</template>


<style scoped>
.small {
  height: 440px;
  width: 160px;
  position: fixed; /* To position the div relative to the browser window */
  bottom: 0; /* To align the bottom of the div with the bottom of the browser window */
  left: calc(50% + 600px); /* To position the div to the right of the big div */
  margin-bottom: 160px; /* To add a small gap between the small div and the bottom of the browser window */
  border-left: solid 1px #ccc;
  padding-left:15px;
}

.small div{
  height: 26px;
  line-height: 26px;
}

.small a{
  color: #2d637c;
  font-size:12px;
}

h1 {
  font-weight: 500;
  font-size: 2.6rem;
  text-align: center;
  margin: 30px auto;
}

h2 {
  font-size: 1.6rem;
  font-weight: 700;;
  border-bottom: solid 1px #ddd;
  margin-top: -30px;
  padding-top:60px;
}

h4 {
  font-size: 1.2rem;
  font-weight: 700;
  margin-top: -30px;
  padding-top:60px;
}

.slogan {
  font-size: 18px;
  text-align: center;
   color: #00323c;
}

.slogan div {
  margin: 10px;
}

.note {
  border-left: solid 5px #ccc;
  color: gray;
  padding: 5px 10px;
  margin: 20px 0;
}

.greetings {
  width: 1200px;
  margin: 0 auto;
}

table {
  width: 1100px;
  font-size: 16px;
}

table tr {
  border: 0;
}

table td,
table th {
  border: 0;
  height: 40px;
  width: 560px;
}

.greetings h1,
.greetings h3 {
  text-align: center;
}


@media (min-width: 1024px) {

  .greetings h3 {
    text-align: left;
  }
}
</style>
