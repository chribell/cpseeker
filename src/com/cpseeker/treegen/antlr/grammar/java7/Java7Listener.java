package com.cpseeker.treegen.antlr.grammar.java7;
// Generated from Java7.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Java7Parser}.
 */
public interface Java7Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Java7Parser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void enterInnerCreator(@NotNull Java7Parser.InnerCreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void exitInnerCreator(@NotNull Java7Parser.InnerCreatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericMethodDeclaration(@NotNull Java7Parser.GenericMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericMethodDeclaration(@NotNull Java7Parser.GenericMethodDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(@NotNull Java7Parser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(@NotNull Java7Parser.ExpressionListContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(@NotNull Java7Parser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(@NotNull Java7Parser.TypeDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(@NotNull Java7Parser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(@NotNull Java7Parser.ForUpdateContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(@NotNull Java7Parser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(@NotNull Java7Parser.AnnotationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(@NotNull Java7Parser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(@NotNull Java7Parser.EnumConstantContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(@NotNull Java7Parser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(@NotNull Java7Parser.ImportDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodOrConstantRest(@NotNull Java7Parser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodOrConstantRest(@NotNull Java7Parser.AnnotationMethodOrConstantRestContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantName(@NotNull Java7Parser.EnumConstantNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantName(@NotNull Java7Parser.EnumConstantNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(@NotNull Java7Parser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(@NotNull Java7Parser.FinallyBlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarators(@NotNull Java7Parser.VariableDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarators(@NotNull Java7Parser.VariableDeclaratorsContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairs(@NotNull Java7Parser.ElementValuePairsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairs(@NotNull Java7Parser.ElementValuePairsContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(@NotNull Java7Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(@NotNull Java7Parser.InterfaceMethodDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBodyDeclaration(@NotNull Java7Parser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBodyDeclaration(@NotNull Java7Parser.InterfaceBodyDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstants(@NotNull Java7Parser.EnumConstantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstants(@NotNull Java7Parser.EnumConstantsContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(@NotNull Java7Parser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(@NotNull Java7Parser.CatchClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(@NotNull Java7Parser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(@NotNull Java7Parser.ConstantExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(@NotNull Java7Parser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(@NotNull Java7Parser.EnumDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocationSuffix(@NotNull Java7Parser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocationSuffix(@NotNull Java7Parser.ExplicitGenericInvocationSuffixContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(@NotNull Java7Parser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(@NotNull Java7Parser.TypeParameterContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(@NotNull Java7Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(@NotNull Java7Parser.EnumBodyDeclarationsContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(@NotNull Java7Parser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(@NotNull Java7Parser.ForStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(@NotNull Java7Parser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(@NotNull Java7Parser.TypeBoundContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(@NotNull Java7Parser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(@NotNull Java7Parser.StatementExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(@NotNull Java7Parser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(@NotNull Java7Parser.VariableInitializerContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull Java7Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull Java7Parser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericInterfaceMethodDeclaration(@NotNull Java7Parser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericInterfaceMethodDeclaration(@NotNull Java7Parser.GenericInterfaceMethodDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(@NotNull Java7Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(@NotNull Java7Parser.LocalVariableDeclarationStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void enterSuperSuffix(@NotNull Java7Parser.SuperSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void exitSuperSuffix(@NotNull Java7Parser.SuperSuffixContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void enterSynchronizedStatement(@NotNull Java7Parser.SynchronizedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void exitSynchronizedStatement(@NotNull Java7Parser.SynchronizedStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(@NotNull Java7Parser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(@NotNull Java7Parser.FieldDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(@NotNull Java7Parser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(@NotNull Java7Parser.FormalParameterListContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocation(@NotNull Java7Parser.ExplicitGenericInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocation(@NotNull Java7Parser.ExplicitGenericInvocationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(@NotNull Java7Parser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(@NotNull Java7Parser.ParExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#catches}.
	 * @param ctx the parse tree
	 */
	void enterCatches(@NotNull Java7Parser.CatchesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#catches}.
	 * @param ctx the parse tree
	 */
	void exitCatches(@NotNull Java7Parser.CatchesContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(@NotNull Java7Parser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(@NotNull Java7Parser.SwitchLabelContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(@NotNull Java7Parser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(@NotNull Java7Parser.TypeParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(@NotNull Java7Parser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(@NotNull Java7Parser.QualifiedNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(@NotNull Java7Parser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(@NotNull Java7Parser.ClassDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationConstantRest(@NotNull Java7Parser.AnnotationConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationConstantRest(@NotNull Java7Parser.AnnotationConstantRestContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(@NotNull Java7Parser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(@NotNull Java7Parser.TypeNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(@NotNull Java7Parser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(@NotNull Java7Parser.SwitchStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull Java7Parser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull Java7Parser.ArgumentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(@NotNull Java7Parser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(@NotNull Java7Parser.ConstructorBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(@NotNull Java7Parser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(@NotNull Java7Parser.FormalParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(@NotNull Java7Parser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(@NotNull Java7Parser.TypeArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(@NotNull Java7Parser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(@NotNull Java7Parser.ThrowStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(@NotNull Java7Parser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(@NotNull Java7Parser.ForInitContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull Java7Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull Java7Parser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(@NotNull Java7Parser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(@NotNull Java7Parser.VariableDeclaratorContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeDeclaration(@NotNull Java7Parser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeDeclaration(@NotNull Java7Parser.AnnotationTypeDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#resources}.
	 * @param ctx the parse tree
	 */
	void enterResources(@NotNull Java7Parser.ResourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#resources}.
	 * @param ctx the parse tree
	 */
	void exitResources(@NotNull Java7Parser.ResourcesContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(@NotNull Java7Parser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(@NotNull Java7Parser.FormalParameterContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull Java7Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull Java7Parser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(@NotNull Java7Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(@NotNull Java7Parser.ElementValueArrayInitializerContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#annotationName}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationName(@NotNull Java7Parser.AnnotationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#annotationName}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationName(@NotNull Java7Parser.AnnotationNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForControl(@NotNull Java7Parser.EnhancedForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForControl(@NotNull Java7Parser.EnhancedForControlContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodRest(@NotNull Java7Parser.AnnotationMethodRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodRest(@NotNull Java7Parser.AnnotationMethodRestContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(@NotNull Java7Parser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(@NotNull Java7Parser.PrimaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(@NotNull Java7Parser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(@NotNull Java7Parser.ClassBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceModifier(@NotNull Java7Parser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceModifier(@NotNull Java7Parser.ClassOrInterfaceModifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(@NotNull Java7Parser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(@NotNull Java7Parser.DefaultValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(@NotNull Java7Parser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(@NotNull Java7Parser.VariableModifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclaration(@NotNull Java7Parser.ConstDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclaration(@NotNull Java7Parser.ConstDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#createdName}.
	 * @param ctx the parse tree
	 */
	void enterCreatedName(@NotNull Java7Parser.CreatedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#createdName}.
	 * @param ctx the parse tree
	 */
	void exitCreatedName(@NotNull Java7Parser.CreatedNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(@NotNull Java7Parser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(@NotNull Java7Parser.InterfaceDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(@NotNull Java7Parser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(@NotNull Java7Parser.PackageDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclarator(@NotNull Java7Parser.ConstantDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclarator(@NotNull Java7Parser.ConstantDeclaratorContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(@NotNull Java7Parser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(@NotNull Java7Parser.CatchTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(@NotNull Java7Parser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(@NotNull Java7Parser.TypeArgumentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterClassCreatorRest(@NotNull Java7Parser.ClassCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitClassCreatorRest(@NotNull Java7Parser.ClassCreatorRestContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(@NotNull Java7Parser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(@NotNull Java7Parser.ModifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull Java7Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull Java7Parser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(@NotNull Java7Parser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(@NotNull Java7Parser.InterfaceBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void enterPackageOrTypeName(@NotNull Java7Parser.PackageOrTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void exitPackageOrTypeName(@NotNull Java7Parser.PackageOrTypeNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(@NotNull Java7Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(@NotNull Java7Parser.ClassBodyDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameter(@NotNull Java7Parser.LastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameter(@NotNull Java7Parser.LastFormalParameterContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(@NotNull Java7Parser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(@NotNull Java7Parser.ForControlContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(@NotNull Java7Parser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(@NotNull Java7Parser.TypeListContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(@NotNull Java7Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(@NotNull Java7Parser.LocalVariableDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(@NotNull Java7Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(@NotNull Java7Parser.VariableDeclaratorIdContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(@NotNull Java7Parser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(@NotNull Java7Parser.CompilationUnitContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(@NotNull Java7Parser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(@NotNull Java7Parser.ElementValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(@NotNull Java7Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(@NotNull Java7Parser.ClassOrInterfaceTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(@NotNull Java7Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(@NotNull Java7Parser.TypeArgumentsOrDiamondContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementDeclaration(@NotNull Java7Parser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementDeclaration(@NotNull Java7Parser.AnnotationTypeElementDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(@NotNull Java7Parser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(@NotNull Java7Parser.BlockStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeBody(@NotNull Java7Parser.AnnotationTypeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeBody(@NotNull Java7Parser.AnnotationTypeBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(@NotNull Java7Parser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(@NotNull Java7Parser.CreatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedNameList(@NotNull Java7Parser.QualifiedNameListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedNameList(@NotNull Java7Parser.QualifiedNameListContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration(@NotNull Java7Parser.MemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration(@NotNull Java7Parser.MemberDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(@NotNull Java7Parser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(@NotNull Java7Parser.TryStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(@NotNull Java7Parser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(@NotNull Java7Parser.DoStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(@NotNull Java7Parser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(@NotNull Java7Parser.MethodDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementRest(@NotNull Java7Parser.AnnotationTypeElementRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementRest(@NotNull Java7Parser.AnnotationTypeElementRestContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(@NotNull Java7Parser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(@NotNull Java7Parser.ResourceSpecificationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(@NotNull Java7Parser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(@NotNull Java7Parser.ConstructorDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(@NotNull Java7Parser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(@NotNull Java7Parser.ResourceContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(@NotNull Java7Parser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(@NotNull Java7Parser.ElementValuePairContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(@NotNull Java7Parser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(@NotNull Java7Parser.IfStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(@NotNull Java7Parser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(@NotNull Java7Parser.MethodBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(@NotNull Java7Parser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(@NotNull Java7Parser.ArrayInitializerContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArgumentsOrDiamond(@NotNull Java7Parser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArgumentsOrDiamond(@NotNull Java7Parser.NonWildcardTypeArgumentsOrDiamondContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(@NotNull Java7Parser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(@NotNull Java7Parser.WhileStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(@NotNull Java7Parser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(@NotNull Java7Parser.PrimitiveTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArguments(@NotNull Java7Parser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArguments(@NotNull Java7Parser.NonWildcardTypeArgumentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreatorRest(@NotNull Java7Parser.ArrayCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreatorRest(@NotNull Java7Parser.ArrayCreatorRestContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(@NotNull Java7Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(@NotNull Java7Parser.InterfaceMemberDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericConstructorDeclaration(@NotNull Java7Parser.GenericConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericConstructorDeclaration(@NotNull Java7Parser.GenericConstructorDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull Java7Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull Java7Parser.LiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link Java7Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(@NotNull Java7Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(@NotNull Java7Parser.SwitchBlockStatementGroupContext ctx);
}