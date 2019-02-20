/**
 * Created by derteuffel on 03/02/2019.
 */

/** Ajout langue parlées**/
$("#confirmTalkingLanguage").click(()=>{
    let talkingLanguageValue= $("#talkingLanguage").val();
    $("#talkingLanguage").val( talkingLanguageValue + ($("#talkingLanguageContent").val())+";");
$("#talkingLanguageList").append('<li class="list-group-item mt-1">'+
    $("#talkingLanguageContent").val()+'</li>');
$("#talkingLanguage").attr("value", $("#talkingLanguage").val());
//close modal after button click
$('#addtalkingLanguage').modal('hide');
//clear input after button click
$('input[id="#talkingLanguageContent"]').val('');
})

/** aJOUT LANGUE 2ecrite**/
$("#confirmWritingLanguage").click(()=>{
    let writingLanguageValue= $("#writingLanguage").val();
$("#writingLanguage").val( writingLanguageValue + ($("#writingLanguageContent").val())+";");
$("#writingLanguageList").append('<li class="list-group-item mt-1">'+
    $("#writingLanguageContent").val()+'</li>');
$("#writingLanguage").attr("value", $("#writingLanguage").val());
//close modal after button click
$('#addwritingLanguage').modal('hide');
//clear input after button click
$('input[id="#writingLanguageContent"]').val('');
})

/** Ajout des Spécialité**/
$("#confirmSpecialiteBtn").click(()=>{
    let specialiteValue= $("#specialitie").val();
$("#specialitie").val( specialiteValue + ($("#specialitieContent").val())+";");
$("#specialitiesList").append('<li class="list-group-item mt-1">'+
    $("#specialitieContent").val()+'</li>');
$("#specialitie").attr("value", $("#specialitie").val());
//close modal after button click
$('#addSpecialities').modal('hide');
//clear input after button click
$('input[id="#specialitieContent"]').val('');
})

/** Ajout des antecedant Medicaux**/
$("#confirmAddMedicalBackup").click(()=>{
    let medicalBackupValue= $("#medicalBackup").val();
$("#medicalBackup").val( medicalBackupValue + ($("#medicalBackupContent").val())+";");
$("#medicalBackupList").append('<li class="list-group-item mt-1">'+
    $("#medicalBackupContent").val()+'</li>');
$("#medicalBackup").attr("value", $("#medicalBackup").val());
//close modal after button click
$('#addMedicalBackup').modal('hide');
//clear input after button click
$('input[id="#medicalBackupContent"]').val('');
})

/** Ajout des Décorations et dates**/
$("#confirmAddDecorationAndDate").click(()=>{
    let  decorationsAndDateValue= $("#decorationsAndDate").val();
$("#decorationsAndDate").val( decorationsAndDateValue + ($("#decorationsAndDateContent").val())+";");
$("#decorationsAndDateList").append('<li class="list-group-item mt-1">'+
    $("#decorationsAndDateContent").val()+'</li>');
$("#decorationsAndDate").attr("value", $("#decorationsAndDate").val());
//close modal after button click
$('#addDecorationsAndDate').modal('hide');
//clear input after button click
$('input[id="#decorationsAndDateContent"]').val('');
})

/** Ajout des cours et stages suivis**/
$("#confirmAddInternshipAndCourse").click(()=>{
    let  internshipAndCourseValue= $("#internshipAndCourse").val();
$("#internshipAndCourse").val( internshipAndCourseValue + ($("#internshipAndCourseContent").val())+";");
$("#internshipAndCourseList").append('<li class="list-group-item mt-1">'+
    $("#internshipAndCourseContent").val()+'</li>');
$("#internshipAndCourse").attr("value", $("#internshipAndCourse").val());
//close modal after button click
$('#addInternshipAndCourse').modal('hide');
//clear input after button click
$('input[id="#internshipAndCourseContent"]').val('');
})

/** Ajout des connaissances anterieures**/
$("#confirmAddLastKnowledge").click(()=>{
    let  lastKnowledgeValue= $("#lastKnowledge").val();
$("#lastKnowledge").val( lastKnowledgeValue + ($("#lastKnowledgeContent").val())+";");
$("#lastKnowledgeList").append('<li class="list-group-item mt-1">'+
    $("#lastKnowledgeContent").val()+'</li>');
$("#lastKnowledge").attr("value", $("#lastKnowledge").val());
//close modal after button click
$('#addLastKnowledge').modal('hide');
//clear input after button click
$('input[id="#lastKnowledgeContent"]').val('');
})

/** Ajout des Sports pratiques**/
$("#confirmAddSport").click(()=>{
    let  sportValue= $("#sport").val();
$("#sport").val( sportValue + ($("#sportContent").val())+";");
$("#sportList").append('<li class="list-group-item mt-1">'+
    $("#sportContent").val()+'</li>');
$("#sport").attr("value", $("#sport").val());
//close modal after button click
$('#addsport').modal('hide');
//clear input after button click
$('input[id="#sportContent"]').val('');
})

/** Ajout des %arque particulières**/
$("#confirmAddparticularMark").click(()=>{
    let  particularMarkValue= $("#particularMark").val();
$("#particularMark").val( particularMarkValue + ($("#particularMarkContent").val())+";");
$("#particularMarkList").append('<li class="list-group-item mt-1">'+
    $("#particularMarkContent").val()+'</li>');
$("#particularMark").attr("value", $("#particularMark").val());
//close modal after button click
$('#addparticularMark').modal('hide');
//clear input after button click
$('input[id="#paparticularMarkContent"]').val('');
})
