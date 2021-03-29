package org.phenopackets.schema.v2.io;

import org.junit.jupiter.api.Test;
import org.phenopackets.schema.v2.Phenopacket;
import org.phenopackets.schema.v2.examples.TestExamples;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Jules Jacobsen <j.jacobsen@qmul.ac.uk>
 */
class PhenopacketFormatTest {

    @Test
    void roundTripping() throws IOException {
        Phenopacket original = TestExamples.rareDiseasePhenopacket();

        String asYaml = PhenopacketFormat.toYaml(original);
        System.out.println(asYaml);

        String asJson = FormatMapper.yamlToJson(asYaml);
        System.out.println(asJson);

        Phenopacket fromJson = PhenopacketFormat.fromJson(asJson);

        //Ta-da!
        assertThat(fromJson, equalTo(original));
    }

    @Test
    void toFromJson() throws Exception {
        Phenopacket original = TestExamples.cancerPhenopacket();

        String asJson = PhenopacketFormat.toJson(original);
        System.out.println(asJson);

        Phenopacket transformed = PhenopacketFormat.fromJson(asJson);
        assertThat(transformed, equalTo(original));
    }

    @Test
    void toFromYaml() throws Exception {
        Phenopacket original = TestExamples.biosamplesPhenopacket();

        String asYaml = PhenopacketFormat.toYaml(original);
        System.out.println(asYaml);

        Phenopacket transformed = PhenopacketFormat.fromYaml(asYaml);
        assertThat(transformed, equalTo(original));
    }
}