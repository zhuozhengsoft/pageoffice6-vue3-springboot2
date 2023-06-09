import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const router = createRouter({
    history: createWebHistory(
        import.meta.env.BASE_URL),

    routes: [{
            path: '/',
            name: 'home',
            component: Home
        },
        //basic
        {
            path: '/basic/SimpleWord',
            name: 'SimpleWord',
            component: () =>
                import ('../views/basic/SimpleWord.vue')
        },
        {
            path: '/basic/OpenDisk',
            name: 'OpenDisk',
            component: () =>
                import ('../views/basic/OpenDisk.vue')
        },
        {
            path: '/basic/TitleText',
            name: 'TitleText',
            component: () =>
                import ('../views/basic/TitleText.vue')
        },
        {
            path: '/basic/CustomToolButton1',
            name: 'CustomToolButton1',
            component: () =>
                import ('../views/basic/CustomToolButton1.vue')
        },
        {
            path: '/basic/HideOfficeToolbar',
            name: 'HideOfficeToolbar',
            component: () =>
                import ('../views/basic/HideOfficeToolbar.vue')
        },
        {
            path: '/basic/HideCustomToolbar',
            name: 'HideCustomToolbar',
            component: () =>
                import ('../views/basic/HideCustomToolbar.vue')
        },
        {
            path: '/basic/DisablePrint',
            name: 'DisablePrint',
            component: () =>
                import ('../views/basic/DisablePrint.vue')
        },
        {
            path: '/basic/SaveReturnValue',
            name: 'SaveReturnValue',
            component: () =>
                import ('../views/basic/SaveReturnValue.vue')
        },
        {
            path: '/basic/SendParameters',
            name: 'SendParameters',
            component: () =>
                import ('../views/basic/SendParameters.vue')
        },
        {
            path: '/basic/SendParameters2',
            name: 'SendParameters2',
            component: () =>
                import ('../views/basic/SendParameters2.vue')
        },
        {
            path: '/basic/CallParentFunction/index',
            name: 'index',
            component: () =>
                import ('../views/basic/CallParentFunction/Index.vue')
        },
        {
            path: '/basic/CallParentFunction/CallParentFunction',
            name: 'CallParentFunction',
            component: () =>
                import ('../views/basic/CallParentFunction/CallParentFunction.vue')
        },
        {
            path: '/basic/GetParentParamValue',
            name: 'GetParentParamValue',
            component: () =>
                import ('../views/basic/GetParentParamValue.vue')
        },
        {
            path: '/basic/SaveAsHTML',
            name: 'SaveAsHTML',
            component: () =>
                import ('../views/basic/SaveAsHTML.vue')
        },
        {
            path: '/basic/SaveAsMHT',
            name: 'SaveAsMHT',
            component: () =>
                import ('../views/basic/SaveAsMHT.vue')
        },
        {
            path: '/basic/SaveAsPDF',
            name: 'SaveAsPDF',
            component: () =>
                import ('../views/basic/SaveAsPDF.vue')
        },
        {
            path: '/basic/SaveDataAndFile',
            name: 'SaveDataAndFile',
            component: () =>
                import ('../views/basic/SaveDataAndFile.vue')
        },
        {
            path: '/basic/AfterDocOpened',
            name: 'AfterDocOpened',
            component: () =>
                import ('../views/basic/AfterDocOpened.vue')
        },
        {
            path: '/basic/BeforeSave',
            name: 'BeforeSave',
            component: () =>
                import ('../views/basic/BeforeSave.vue')
        },
        {
            path: '/basic/AfterSave',
            name: 'AfterSave',
            component: () =>
                import ('../views/basic/AfterSave.vue')
        },
        {
            path: '/basic/DataBase',
            name: 'DataBase',
            component: () =>
                import ('../views/basic/DataBase.vue')
        },
        {
            path: '/basic/CreateWord',
            name: 'CreateWord',
            component: () =>
                import ('../views/basic/CreateWord.vue')
        },
        {
            path: '/basic/POBrowserPosition',
            name: 'POBrowserPosition',
            component: () =>
                import ('../views/basic/POBrowserPosition.vue')
        },
        {
            path: '/basic/OpenOssDoc',
            name: 'OpenOssDoc',
            component: () =>
                import ('../views/basic/OpenOssDoc.vue')
        },
        {
            path: '/basic/NoBlank',
            name: 'NoBlank',
            component: () =>
                import ('../views/basic/NoBlank.vue')
        },
        //word-常规
        {
            path: '/word/normal/RevisionOnly',
            name: 'RevisionOnly',
            component: () =>
                import ('../views/word/normal/RevisionOnly.vue')
        },
        {
            path: '/word/normal/RevisionsList',
            name: 'RevisionsList',
            component: () =>
                import ('../views/word/normal/RevisionsList.vue')
        },
        {
            path: '/word/normal/ReadOnly',
            name: 'ReadOnly',
            component: () =>
                import ('../views/word/normal/ReadOnly.vue')
        },
        {
            path: '/word/normal/ReadOnly2',
            name: 'ReadOnly2',
            component: () =>
                import ('../views/word/normal/ReadOnly2.vue')
        },
        {
            path: '/word/normal/InsertSeal/Index',
            name: 'InsertSeal',
            component: () =>
                import ('../views/word/normal/InsertSeal/Index.vue')
        },
        {
            path: '/word/normal/InsertSeal/AddSeal/Word1',
            component: () =>
                import ("../views/word/normal/InsertSeal/AddSeal/Word1.vue")
        },
        {
            path: '/word/normal/InsertSeal/AddSeal/Word2',
            component: () =>
                import ("../views/word/normal/InsertSeal/AddSeal/Word2.vue")
        },
        {
            path: '/word/normal/InsertSeal/AddSeal/Word3',
            component: () =>
                import ("../views/word/normal/InsertSeal/AddSeal/Word3.vue")
        },
        {
            path: '/word/normal/InsertSeal/AddSeal/Word4',
            component: () =>
                import ("../views/word/normal/InsertSeal/AddSeal/Word4.vue")
        },
        {
            path: '/word/normal/InsertSeal/AddSeal/Word5',
            component: () =>
                import ("../views/word/normal/InsertSeal/AddSeal/Word5.vue")
        },
        {
            path: '/word/normal/InsertSeal/AddSeal/Word6',
            component: () =>
                import ("../views/word/normal/InsertSeal/AddSeal/Word6.vue")
        },
        {
            path: '/word/normal/InsertSeal/AddSeal/Word7',
            component: () =>
                import ("../views/word/normal/InsertSeal/AddSeal/Word7.vue")
        },
        {
            path: '/word/normal/InsertSeal/AddSeal/Word8',
            component: () =>
                import ("../views/word/normal/InsertSeal/AddSeal/Word8.vue")
        },
        {
            path: '/word/normal/InsertSeal/BatchAddSeal/index',
            component: () =>
                import ("../views/word/normal/InsertSeal/BatchAddSeal/index.vue")
        },
        {
            path: '/word/normal/InsertSeal/AddSeal/Word10',
            component: () =>
                import ("../views/word/normal/InsertSeal/AddSeal/Word10.vue")
        },
        {
            path: '/word/normal/InsertSeal/AddSign/Word1',
            component: () =>
                import ("../views/word/normal/InsertSeal/AddSign/Word1.vue")
        },
        {
            path: '/word/normal/InsertSeal/AddSign/Word2',
            component: () =>
                import ("../views/word/normal/InsertSeal/AddSign/Word2.vue")
        },
        {
            path: '/word/normal/InsertSeal/AddSign/Word3',
            component: () =>
                import ("../views/word/normal/InsertSeal/AddSign/Word3.vue")
        },
        {
            path: '/word/normal/InsertSeal/AddSign/Word4',
            component: () =>
                import ("../views/word/normal/InsertSeal/AddSign/Word4.vue")
        },
        {
            path: '/word/normal/InsertSeal/AddSign/Word5',
            component: () =>
                import ("../views/word/normal/InsertSeal/AddSign/Word5.vue")
        },
        {
            path: '/word/normal/InsertPageBreak2',
            name: 'InsertPageBreak2',
            component: () =>
                import ('../views/word/normal/InsertPageBreak2.vue')
        },
        // {
        //     path: '/word/normal/HandDrawsList',
        //     name: 'HandDrawsList',
        //     component: () =>
        //         import ('../views/word/normal/HandDrawsList.vue')
        // },
        //word-js控制
        {
            path: '/word/js/WordAddBKMK',
            name: 'WordAddBKMK',
            component: () =>
                import ('../views/word/js/WordAddBKMK.vue')
        },
        {
            path: '/word/js/WordDelBKMK',
            name: 'WordDelBKMK',
            component: () =>
                import ('../views/word/js/WordDelBKMK.vue')
        },

        {
            path: '/word/js/InsertImgForJs',
            name: 'InsertImgForJs',
            component: () =>
                import ('../views/word/js/InsertImgForJs.vue')
        },
        {
            path: '/word/js/WordHyperLink',
            name: 'WordHyperLink',
            component: () =>
                import ('../views/word/js/WordHyperLink.vue')
        },
        {
            path: '/word/js/InsertWaterMarkForJs',
            name: 'InsertWaterMarkForJs',
            component: () =>
                import ('../views/word/js/InsertWaterMarkForJs.vue')
        },
        {
            path: '/word/js/WordLocateBKMK',
            name: 'WordLocateBKMK',
            component: () =>
                import ('../views/word/js/WordLocateBKMK.vue')
        },
        {
            path: '/word/js/WordGetSelection',
            name: 'WordGetSelection',
            component: () =>
                import ('../views/word/js/WordGetSelection.vue')
        },
        {
            path: '/word/js/WordGoToPage',
            name: 'WordGoToPage',
            component: () =>
                import ('../views/word/js/WordGoToPage.vue')
        },
        {
            path: '/word/js/DocumentMap',
            name: 'DocumentMap',
            component: () =>
                import ('../views/word/js/DocumentMap.vue')
        },
        {
            path: '/word/js/PageCount',
            name: 'PageCount',
            component: () =>
                import ('../views/word/js/PageCount.vue')
        },
        {
            path: '/word/js/PageNum',
            name: 'PageNum',
            component: () =>
                import ('../views/word/js/PageNum.vue')
        },
        {
            path: '/word/js/ZoomPercentage',
            name: 'ZoomPercentage',
            component: () =>
                import ('../views/word/js/ZoomPercentage.vue')
        },
        //word-数据填充
        {
            path: '/word/insert/DataRegionFill',
            name: 'DataRegionFill',
            component: () =>
                import ('../views/word/insert/DataRegionFill.vue')
        },
        {
            path: '/word/insert/WordResImage',
            name: 'WordResImage',
            component: () =>
                import ('../views/word/insert/WordResImage.vue')
        },
        {
            path: '/word/insert/DataRegionStyle',
            name: 'DataRegionStyle',
            component: () =>
                import ('../views/word/insert/DataRegionStyle.vue')
        },
        {
            path: '/word/insert/WordCreateTable',
            name: 'WordCreateTable',
            component: () =>
                import ('../views/word/insert/WordCreateTable.vue')
        },
        {
            path: '/word/normal/WordResWord',
            name: 'WordResWord',
            component: () =>
                import ('../views/word/normal/WordResWord.vue')
        },
        {
            path: '/word/insert/WordResExcel',
            name: 'WordResExcel',
            component: () =>
                import ('../views/word/insert/WordResExcel.vue')
        },
        {
            path: '/word/normal/DataRegionReadOnly',
            name: 'DataRegionReadOnly',
            component: () =>
                import ('../views/word/normal/DataRegionReadOnly.vue')
        },
        {
            path: '/word/insert/WordDataTag',
            name: 'WordDataTag',
            component: () =>
                import ('../views/word/insert/WordDataTag.vue')
        },
        {
            path: '/word/insert/WordDataTag2',
            name: 'WordDataTag2',
            component: () =>
                import ('../views/word/insert/WordDataTag2.vue')
        },
        {
            path: '/word/insert/DataRegionFill2',
            name: 'DataRegionFill2',
            component: () =>
                import ('../views/word/insert/DataRegionFill2.vue')
        },
        {
            path: '/word/normal/DataRegionEdit',
            name: 'DataRegionEdit',
            component: () =>
                import ('../views/word/normal/DataRegionEdit/DataRegionEdit.vue')
        },
        {
            path: '/word/normal/DataRegionEdit/DataRegionDlg',
            component: () =>
                import ("../views/word/normal/DataRegionEdit/DataRegionDlg.vue")
        },
        {
            path: '/word/normal/DataTagEdit',
            name: 'DataTagEdit',
            component: () =>
                import ('../views/word/normal/DataTagEdit/DataTagEdit.vue')
        },
        {
            path: '/word/normal/DataTagEdit/DataTagDlg',
            component: () =>
                import ("../views/word/normal/DataTagEdit/DataTagDlg.vue")
        },
        {
            path: '/word/insert/TableInsertRow',
            name: 'TableInsertRow',
            component: () =>
                import ('../views/word/insert/TableInsertRow.vue')
        },
        {
            path: '/word/insert/MergeWordCell',
            name: 'MergeWordCell',
            component: () =>
                import ('../views/word/insert/MergeWordCell.vue')
        },
        {
            path: '/word/insert/WordTableSetImg',
            name: 'WordTableSetImg',
            component: () =>
                import ('../views/word/insert/WordTableSetImg.vue')
        },
        {
            path: '/word/insert/WordTableBorder',
            name: 'WordTableBorder',
            component: () =>
                import ('../views/word/insert/WordTableBorder.vue')
        },
        {
            path: '/word/insert/WordSetTable',
            name: 'WordSetTable',
            component: () =>
                import ('../views/word/insert/WordSetTable.vue')
        },
        {
            path: '/word/insert/WordDeleteRow',
            name: 'WordDeleteRow',
            component: () =>
                import ('../views/word/insert/WordDeleteRow.vue')
        },
        {
            path: '/word/insert/DataRegionCreate',
            name: 'DataRegionCreate',
            component: () =>
                import ('../views/word/insert/DataRegionCreate.vue')
        },
        {
            path: '/word/insert/WordParagraph',
            name: 'WordParagraph',
            component: () =>
                import ('../views/word/insert/WordParagraph.vue')
        },
        {
            path: '/word/insert/InsertImageSetSize',
            name: 'InsertImageSetSize',
            component: () =>
                import ('../views/word/insert/InsertImageSetSize.vue')
        },
        {
            path: '/word/normal/AddWaterMark',
            name: 'AddWaterMark',
            component: () =>
                import ('../views/word/normal/AddWaterMark.vue')
        },
        {
            path: '/word/normal/AddWaterMark2',
            name: 'AddWaterMark2',
            component: () =>
                import ('../views/word/normal/AddWaterMark2.vue')
        },
        {
            path: '/word/insert/WordTextBox',
            name: 'WordTextBox',
            component: () =>
                import ('../views/word/insert/WordTextBox.vue')
        },
        // {
        //     path: '/word/insert/TaoHong',
        //     name: 'TaoHong',
        //     component: () =>
        //         import ('../views/word/insert/TaoHong.vue')
        // },
        // {
        //     path: '/word/insert/MergeWord',
        //     name: 'MergeWord',
        //     component: () =>
        //         import ('../views/word/insert/MergeWord.vue')
        // },

        //word-数据提交
        {
            path: '/word/extract/SubmitWord',
            name: 'SubmitWord',
            component: () =>
                import ('../views/word/extract/SubmitWord.vue')
        },
        {
            path: '/word/extract/ExtractImage',
            name: 'ExtractImage',
            component: () =>
                import ('../views/word/extract/ExtractImage.vue')
        },
        {
            path: '/word/extract/SplitWord',
            name: 'SplitWord',
            component: () =>
                import ('../views/word/extract/SplitWord.vue')
        },
        {
            path: '/word/extract/SubmitTable',
            name: 'SubmitTable',
            component: () =>
                import ('../views/word/extract/SubmitTable.vue')
        },
        // {
        //     path: '/word/extract/ImportWordData',
        //     name: 'ImportWordData',
        //     component: () =>
        //         import ('../views/word/extract/ImportWordData.vue')
        // },
        // //FileMaker
        // {
        //     path: '/filemaker/FileMakerSingle',
        //     name: 'FileMakerSingle',
        //     component: () =>
        //         import ('../views/filemaker/FileMakerSingle.vue')
        // },
        // {
        //     path: '/filemaker/FileMakerPDF',
        //     name: 'FileMakerPDF',
        //     component: () =>
        //         import ('../views/filemaker/FileMakerPDF.vue')
        // },
        // {
        //     path: '/filemaker/FileMakerMulti',
        //     name: 'FileMakerMulti',
        //     component: () =>
        //         import ('../views/filemaker/FileMakerMulti.vue')
        // },
        // {
        //     path: '/filemaker/FileMakerConvertPDFs',
        //     name: 'FileMakerConvertPDFs',
        //     component: () =>
        //         import ('../views/filemaker/FileMakerConvertPDFs.vue')
        // },
        // {
        //     path: '/filemaker/PrintFiles',
        //     name: 'PrintFiles',
        //     component: () =>
        //         import ('../views/filemaker/PrintFiles.vue')
        // },

        // //word-更多
        // {
        //     path: '/word/more/WordHandDraw',
        //     name: 'WordHandDraw',
        //     component: () =>
        //         import ('../views/word/more/WordHandDraw.vue')
        // },
        {
            path: '/word/normal/SaveFirstPageAsImg',
            name: 'SaveFirstPageAsImg',
            component: () =>
                import ('../views/word/normal/SaveFirstPageAsImg.vue')
        },
        {
            path: '/word/more/ClickDataRegion',
            name: 'ClickDataRegion',
            component: () =>
                import ('../views/word/more/ClickDataRegion/ClickDataRegion.vue')
        },
        {
            path: '/word/more/ClickDataRegionDlg',
            name: 'ClickDataRegionDlg',
            component: () =>
                import ('../views/word/more/ClickDataRegion/ClickDataRegionDlg.vue')
        },
        {
            path: '/word/normal/WordCompare',
            name: 'WordCompare',
            component: () =>
                import ('../views/word/normal/WordCompare.vue')
        },
        // {
        //     path: '/word/more/SetDrByUserWord',
        //     name: 'SetDrByUserWord',
        //     component: () =>
        //         import ('../views/word/more/SetDrByUserWord.vue')
        // },
        // {
        //     path: '/word/more/SetHandDrawByUser',
        //     name: 'SetHandDrawByUser',
        //     component: () =>
        //         import ('../views/word/more/SetHandDrawByUser.vue')
        // },
        // {
        //     path: '/word/more/huiqiandan',
        //     name: 'huiqiandan',
        //     component: () =>
        //         import ('../views/word/more/huiqiandan.vue')
        // },
        // {
        //     path: '/word/more/huiqiandan2',
        //     name: 'huiqiandan2',
        //     component: () =>
        //         import ('../views/word/more/huiqiandan2.vue')
        // },
        // {
        //     path: '/word/more/CommentsList',
        //     name: 'CommentsList',
        //     component: () =>
        //         import ('../views/word/more/CommentsList.vue')
        // },
        {
            path: '/word/normal/DisableCopyOut',
            name: 'DisableCopyOut',
            component: () =>
                import ('../views/word/normal/DisableCopyOut.vue')
        },
        // {
        //     path: '/word/more/SaveAndSearch',
        //     name: 'SaveAndSearch',
        //     component: () =>
        //         import ('../views/word/more/SaveAndSearch.vue')
        // },
        {
            path: '/word/normal/WordDisableRight',
            name: 'WordDisableRight',
            component: () =>
                import ('../views/word/normal/WordDisableRight.vue')
        },
        {
            path: '/word/normal/SameTimeEdit/Index',
            name: 'SameTimeEdit',
            component: () =>
                import ('../views/word/normal/SameTimeEdit/Index.vue')
        },
        {
            path: '/word/normal/SameTimeEdit/Word',
            component: () =>
                import ("../views/word/normal/SameTimeEdit/Word.vue")
        },
        {
            path: '/word/normal/CreateBlankFile',
            component: () =>
                import ("../views/word/normal/CreateBlankFile.vue")
        },
        //excel-常规
        {
            path: '/excel/normal/SimpleExcel',
            name: 'NormalEdit',
            component: () =>
                import ('../views/excel/normal/SimpleExcel.vue')
        },
        {
            path: '/excel/normal/ReadOnlyExcel',
            name: 'ReadOnlyExcel',
            component: () =>
                import ('../views/excel/normal/ReadOnlyExcel.vue')
        },
        {
            path: '/excel/normal/ExcelAdjustRC',
            name: 'ExcelAdjustRC',
            component: () =>
                import ('../views/excel/normal/ExcelAdjustRC.vue')
        },
        {
            path: '/excel/normal/ExcelDisableRight',
            name: 'ExcelDisableRight',
            component: () =>
                import ('../views/excel/normal/ExcelDisableRight.vue')
        },
        //excel-数据填充
        {
            path: '/excel/insert/ExcelFill',
            name: 'ExcelFill',
            component: () =>
                import ('../views/excel/insert/ExcelFill.vue')
        },
        {
            path: '/excel/insert/ExcelInsertImage',
            name: 'ExcelInsertImage',
            component: () =>
                import ('../views/excel/insert/ExcelInsertImage.vue')
        },
        {
            path: '/excel/insert/SetExcelCellText',
            name: 'SetExcelCellText',
            component: () =>
                import ('../views/excel/insert/SetExcelCellText.vue')
        },
        {
            path: '/excel/insert/ExcelFill2',
            name: 'ExcelFill2',
            component: () =>
                import ('../views/excel/insert/ExcelFill2.vue')
        },
        {
            path: '/excel/insert/SetExcelCellText2',
            name: 'SetExcelCellText2',
            component: () =>
                import ('../views/excel/insert/SetExcelCellText2.vue')
        },
        {
            path: '/excel/insert/DefinedNameCell',
            name: 'DefinedNameCell',
            component: () =>
                import ('../views/excel/insert/DefinedNameCell.vue')
        },
        {
            path: '/excel/insert/DefinedNameTable',
            name: 'DefinedNameTable',
            component: () =>
                import ('../views/excel/insert/DefinedNameTable.vue')
        },
        {
            path: '/excel/insert/ExcelTable',
            name: 'ExcelTable',
            component: () =>
                import ('../views/excel/insert/ExcelTable.vue')
        },
        {
            path: '/excel/insert/DrawExcel',
            name: 'DrawExcel',
            component: () =>
                import ('../views/excel/insert/DrawExcel.vue')
        },
        {
            path: '/excel/insert/ExcelBorder',
            name: 'ExcelBorder',
            component: () =>
                import ('../views/excel/insert/ExcelBorder.vue')
        },

        //excel-数据提交
        {
            path: '/excel/extract/SubmitExcel',
            name: 'SubmitExcel',
            component: () =>
                import ('../views/excel/extract/SubmitExcel.vue')
        },
        {
            path: '/excel/extract/ImportExcelData',
            name: 'ImportExcelData',
            component: () =>
                import ('../views/excel/extract/ImportExcelData.vue')
        },
        //excel-更多
        // {
        //     path: '/excel/more/SetXlsTableByUser',
        //     name: 'SetXlsTableByUser',
        //     component: () =>
        //         import ('../views/excel/more/SetXlsTableByUser.vue')
        // },
        // {
        //     path: '/excel/more/ExcelCellClick',
        //     name: 'ExcelCellClick',
        //     component: () =>
        //         import ('../views/excel/more/ExcelCellClick.vue')
        // },
        // {
        //     path: '/excel/more/JsOpXlsCellText',
        //     name: 'JsOpXlsCellText',
        //     component: () =>
        //         import ('../views/excel/more/JsOpXlsCellText.vue')
        // },


        //pdf
        {
            path: '/pdf/POPDF',
            name: 'POPDF',
            component: () =>
                import ('../views/pdf/POPDF.vue')
        },
        {
            path: '/pdf/CustomToolButton',
            name: 'CustomToolButton',
            component: () =>
                import ('../views/pdf/CustomToolButton.vue')
        },
        {
            path: '/pdf/PDFSearch',
            name: 'PDFSearch',
            component: () =>
                import ('../views/pdf/PDFSearch.vue')
        },

        //ppt
        {
            path: '/ppt/SimplePPT',
            name: 'SimplePPT',
            component: () =>
                import ('../views/ppt/SimplePPT.vue')
        },
        {
            path: '/ppt/ReadOnlyPPT',
            name: 'ReadOnlyPPT',
            component: () =>
                import ('../views/ppt/ReadOnlyPPT.vue')
        },


    ]
})

export default router