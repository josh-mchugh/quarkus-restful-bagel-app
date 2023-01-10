package com.communitybagelco.arch;

import org.junit.jupiter.api.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

import io.quarkus.test.junit.QuarkusIntegrationTest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchUnitTest {
    
    @Test
    public void verifyThatQuarkusIntegrationTestsExists() {

        JavaClasses classes = new ClassFileImporter().importPackages("com.communitybagelco");

        ArchRule myRule = classes()
            .that().haveNameMatching(".*IT")
            .should().beAnnotatedWith(QuarkusIntegrationTest.class);

        myRule.check(classes);
    }
}
