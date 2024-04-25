
ALTER TABLE medic_category
    MODIFY COLUMN id BIGINT AUTO_INCREMENT;

ALTER TABLE medic
    MODIFY COLUMN id BIGINT AUTO_INCREMENT;

INSERT INTO medic_category(label, description) VALUES
                      ('Antibiotic', 'Used to treat bacterial infections.'),
                      ('Analgesic', 'Used for relief from pain.'),
                      ('Antiseptic', 'Used to prevent the growth of disease-causing microorganisms.'),
                      ('Antipyretic', 'Used to prevent or reduce fever.'),
                      ('Antihistamine', 'Used to treat allergic reactions.');


-- Medics for Category 1: Antibiotic
INSERT INTO medic(name, usage_description, category_id) VALUES
                                                 ('Amoxicillin', 'Take one tablet three times a day', 1),
                                                 ('Doxycycline', 'Take one tablet daily', 1),
                                                 ('Cephalexin', 'Take one tablet every 8 hours', 1),
                                                 ('Clindamycin', 'Take one capsule every 6 hours', 1),
                                                 ('Azithromycin', 'Take one tablet daily for three days', 1),
                                                 ('Ciprofloxacin', 'Take one tablet twice a day', 1),
                                                 ('Levofloxacin', 'Take one tablet daily', 1),
                                                 ('Metronidazole', 'Take one tablet three times a day', 1),
                                                 ('Vancomycin', 'Take one capsule twice a day', 1),
                                                 ('Erythromycin', 'Take one tablet every 6 hours', 1);

-- Medics for Category 2: Analgesic
INSERT INTO Medic (name, usage, category_id) VALUES
                                                 ('Ibuprofen', 'Take one tablet every 4 to 6 hours as needed', 2),
                                                 ('Aspirin', 'Take one to two tablets every 4 to 6 hours', 2),
                                                 ('Acetaminophen', 'Take one tablet every 4 to 6 hours as needed', 2),
                                                 ('Naproxen', 'Take one tablet two times a day', 2),
                                                 ('Diclofenac', 'Take one tablet daily', 2),
                                                 ('Tramadol', 'Take one tablet every 6 hours as needed', 2),
                                                 ('Oxycodone', 'Take one tablet as prescribed for pain', 2),
                                                 ('Morphine', 'Take as directed by healthcare provider', 2),
                                                 ('Celecoxib', 'Take one capsule once or twice a day', 2),
                                                 ('Hydrocodone', 'Take as prescribed for severe pain', 2);

-- Medics for Category 3: Antiseptic
INSERT INTO Medic (name, usage, category_id) VALUES
                                                 ('Hydrogen Peroxide', 'Apply a small amount to the affected area', 3),
                                                 ('Chlorhexidine', 'Use as directed for oral rinsing', 3),
                                                 ('Iodine Solution', 'Apply topically to clean wounds', 3),
                                                 ('Alcohol Rub', 'Use to disinfect hands', 3),
                                                 ('Povidone-Iodine', 'Apply to minor wounds and burns', 3),
                                                 ('Benzalkonium Chloride', 'Apply as needed for skin disinfection', 3),
                                                 ('Thiomersal', 'Use as directed for contact lens solutions', 3),
                                                 ('Cetrimide', 'Apply on skin as an antiseptic', 3),
                                                 ('Phenol', 'Use with caution on wounds', 3),
                                                 ('Boric Acid', 'Use as prescribed for eye infections', 3);

INSERT INTO Medic (name, usage, category_id) VALUES
                                                 ('Paracetamol', 'Take one tablet every 4 to 6 hours as needed', 4),
                                                 ('Ibuprofen', 'Take one tablet every 6 to 8 hours with food', 4),
                                                 ('Aspirin', 'Take 300-600 mg every 4-6 hours as needed', 4),
                                                 ('Naproxen', 'Take one tablet twice a day with food', 4),
                                                 ('Acetaminophen', 'Take 500 mg every 4-6 hours; do not exceed 3000 mg per day', 4),
                                                 ('Diclofenac', 'Apply gel to affected area four times a day', 4),
                                                 ('Indomethacin', 'Take one capsule two to three times a day with food', 4),
                                                 ('Ketoprofen', 'Take 25 mg three times per day with food', 4),
                                                 ('Mefenamic Acid', 'Take 250 mg every 6 hours with food', 4),
                                                 ('Celecoxib', 'Take one 200 mg capsule once a day', 4);


INSERT INTO Medic (name, usage, category_id) VALUES
                                                 ('Diphenhydramine', 'Take 25-50 mg every 4-6 hours as needed', 5),
                                                 ('Loratadine', 'Take one tablet once a day', 5),
                                                 ('Cetirizine', 'Take one tablet once a day', 5),
                                                 ('Fexofenadine', 'Take 180 mg once daily', 5),
                                                 ('Desloratadine', 'Take one tablet once a day', 5),
                                                 ('Levocetirizine', 'Take 5 mg once daily', 5),
                                                 ('Chlorpheniramine', 'Take 4 mg every 4-6 hours as needed', 5),
                                                 ('Promethazine', 'Take 25 mg before bed or 12.5 mg before meals and at bedtime', 5),
                                                 ('Azelastine', 'Spray once or twice in each nostril twice a day', 5),
                                                 ('Olopatadine', 'Apply one drop in each affected eye twice a day', 5);
